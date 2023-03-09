package piconot.internal

import picolib.maze.Maze
import picolib.semantics._
import picolib.display.TextDisplay

import scala.collection.mutable.ListBuffer
 
class Picotext(val mazeFilename: String) extends App {

    private val rules = ListBuffer.empty[Rule]

    def addRule(rule: Rule) = rules += rule

    def run = {
        val maze = Maze(mazeFilename)
        object bot extends Picobot(maze, rules.toList) with TextDisplay
        bot.run()
    }
    
    def n: MoveDirection = North
    def e: MoveDirection = East
    def w: MoveDirection = West
    def s: MoveDirection = South
    def x: MoveDirection = StayHere
    def n_e: List[MoveDirection] = List(North, East)
    def n_e_w: List[MoveDirection] = List(North, East, West)
    def n_e_w_s: List[MoveDirection] = List(North, East, West, South)
    def n_w: List[MoveDirection] = List(North, West)
    def n_w_s: List[MoveDirection] = List(North, West, South)
    def n_s: List[MoveDirection] = List(North, South)
    def e_w_s: List[MoveDirection] = List(East, West, South)
    def e_w: List[MoveDirection] = List(East, West)
    def w_s: List[MoveDirection] = List(West, South)
    def e_s: List[MoveDirection] = List(East, South)
    def n_e_s: List[MoveDirection] = List(North, East, South)
    
    extension(x: Int){
        def empty(n: MoveDirection) = 
            n match
                case North => action(State(x.toString), Surroundings(Open, Anything, Anything, Anything))
                case East => action(State(x.toString), Surroundings(Anything, Open, Anything, Anything))
                case West => action(State(x.toString), Surroundings(Anything, Anything, Open, Anything))
                case South => action(State(x.toString), Surroundings(Anything, Anything, Anything, Open))
        def empty(n: List[MoveDirection]) =
            n match
                case List(North, East) => action(State(x.toString), Surroundings(Open, Open, Blocked, Anything))
                case List(North, East, West) => action(State(x.toString), Surroundings(Open, Open, Open, Anything))
                case List(North, East, West, South) => action(State(x.toString), Surroundings(Open, Open, Open, Open))
                case List(North, West) => action(State(x.toString), Surroundings(Open, Anything, Open, Anything))
                case List(North, West, South) => action(State(x.toString), Surroundings(Open, Anything, Open, Open))
                case List(North, South) => action(State(x.toString), Surroundings(Open, Anything, Anything, Open))
                case List(East, West, South) => action(State(x.toString), Surroundings(Anything, Open, Open, Open))
                case List(East, West) => action(State(x.toString), Surroundings(Anything, Open, Open, Anything))
                case List(West, South) => action(State(x.toString), Surroundings(Anything, Anything, Open, Open))
                case List(East, South) => action(State(x.toString), Surroundings(Anything, Open, Anything, Open))
                case List(North, East, South) => action(State(x.toString), Surroundings(Open, Open, Anything, Open))
        def empty(n: String) =
            n match
                case "n wall e" => action(State(x.toString), Surroundings(Open, Blocked, Anything, Anything))
                case "s wall w" => action(State(x.toString), Surroundings(Anything, Blocked, Anything, Open))
                case "e wall s" => action(State(x.toString), Surroundings(Anything, Open, Anything, Blocked))
                case "w wall n" => action(State(x.toString), Surroundings(Blocked, Anything, Open, Anything))
        def wall(n: MoveDirection) =
            n match 
                case North => action(State(x.toString), Surroundings(Blocked, Anything, Anything, Anything))
                case East => action(State(x.toString), Surroundings(Anything, Blocked, Anything, Anything))
                case West => action(State(x.toString), Surroundings(Anything, Anything, Blocked, Anything))
                case South => action(State(x.toString), Surroundings(Anything, Anything, Anything, Blocked))
        def wall(n: List[MoveDirection]) =
            n match
                case List(North, East) => action(State(x.toString), Surroundings(Blocked, Blocked, Anything, Anything))
                case List(North, East, West) => action(State(x.toString), Surroundings(Blocked, Blocked, Blocked, Anything))
                case List(North, East, West, South) => action(State(x.toString), Surroundings(Blocked, Blocked, Blocked, Blocked))
                case List(North, West) => action(State(x.toString), Surroundings(Blocked, Anything, Blocked, Anything))
                case List(North, West, South) => action(State(x.toString), Surroundings(Blocked, Anything, Blocked, Blocked))
                case List(North, South) => action(State(x.toString), Surroundings(Blocked, Anything, Anything, Blocked))
                case List(East, West, South) => action(State(x.toString), Surroundings(Anything, Blocked, Blocked, Blocked))
                case List(East, West) => action(State(x.toString), Surroundings(Anything, Blocked, Blocked, Anything))
                case List(West, South) => action(State(x.toString), Surroundings(Anything, Anything, Blocked, Blocked))
                case List(East, South) => action(State(x.toString), Surroundings(Anything, Blocked, Anything, Blocked))
                case List(North, East, South) => action(State(x.toString), Surroundings(Blocked, Blocked, Anything, Blocked))
    }


    // use extension for and where there's a condition before and after
    

    class action(x: State, sur: Surroundings){
        //val s: State = State(x.toString)
        val prog = Picotext.this
        def next(rhs: (MoveDirection, Int)) = {
            val (dir, int) = rhs
            val state: State = State(int.toString)
            val rule = new Rule(x, sur, dir, state)
            prog.addRule(rule)
        }
    }
}