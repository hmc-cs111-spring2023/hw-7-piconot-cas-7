package piconot.internal

import picolib.maze.Maze
import picolib.semantics._
import picolib.display.TextDisplay

import scala.collection.mutable.ListBuffer
 
class PicoText(val mazeFilename: String) extends App {
    
    given Conversion[String, MoveDirection] = n => stringToDir(n)
    
    def stringToDir(n: String): MoveDirection =
        n match
            case "e" => East
            case "n" => North
            case "w" => West
            case "s" => South
            case "x" => StayHere
            
    extension(x: Int){
        def empty(n: MoveDirection) = 
            n match
                case East => cond(x, Surroundings(Anything, Open, Anything, Anything))
                case North => cond(x, Surroundings(Open, Anything, Anything, Anything))
                case West => cond(x, Surroundings(Anything, Anything, Open, Anything))
                case South => cond(x, Surroundings(Anything, Anything, Anything, Open))
        def wall(n: MoveDirection) =
            n match 
                case East => cond(x, Surroundings(Anything, Blocked, Anything, Anything))
                case North => cond(x, Surroundings(Blocked, Anything, Anything, Anything))
                case West => cond(x, Surroundings(Anything, Anything, Blocked, Anything))
                case South => cond(x, Surroundings(Anything, Anything, Anything, Blocked))
    }

    extension(n: MoveDirection){
        def `then n` = 
    }

    class cond(x: Int, sur: Surroundings){

    }
}