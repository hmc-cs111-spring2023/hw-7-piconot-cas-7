# Design

## Who is the target for this design, e.g., are you assuming any knowledge on the part of the language users?

My language is similar to picobot, except it's written out more, so it's more similar to written English. The target for this design are users with very little to no programming experience.

## Why did you choose this design, i.e., why did you think it would be a good idea for users to express the maze-searching computation using this syntax?

I was struggling with the design at first, so when I looked at the sample solution, I drew a lot of inspiration from there. I wanted to use more pattern matching, class definitions, and extensions, so this is the language design that resulted from that.

## What behaviors are easier to express in your design than in Picobot’s original design?  If there are no such behaviors, why not?

It's easy to check for multipl empty directions or multiple walls because you can just list them out and the wall and empty methods make it easy to figure out how to check.

## What behaviors are more difficult to express in your design than in Picobot’s original design? If there are no such behaviors, why not?

It's difficult to check whether a combination of directions have walls or are empty. I kinda had to hard code that part with strings. I don't think it'll actually work with every combination. ie. checking if there's a wall to the east and if it's empty to the south.

## On a scale of 1–10 (where 10 is “very different”), how different is your syntax from PicoBot’s original design?

3 I didn't change it that much, I just made it closer to the english language.

## Is there anything you would improve about your design?

I would improve it's ability to check if there's a combination of empty spots next to the bot and walls next to the bot.
