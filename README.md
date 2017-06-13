Viagogo Graduate Developer Test

Scenario:
- Your program should randomly generate seed data
- Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10 to +10 (X axis)
- Your program should assume that each co-ordinate can hold a maximum of one event
- Each event has a unique numeric identifier (e.g. 1, 2, 3)
- Each event has zero or more tickets
- Each ticket has a non-zero price, expressed in US Dollars
- The distance between two points should be computed as the Manhattan distance

The program has been developed using Java with the IDE Eclipse. Thus, to execute the project a good option would be import the project
with Eclipse and run it there. 
The Object Oriented paradigm was follwed and three classes were defined:
-World
-Event
-Ticekt
-Location

Assumptions:

- To generate the seed data, it is assumed that each event has five tickets. 
- The price of these tickets may vary between $50 and $100. The exact price is a double with two decimal positions randomly generated.

Questions:

- How might you change your program if you needed to support multiple events at the same location?
Answer: When the program generates a new event, the method getRandomLocation() (in the class World) invokes the method locationAvailable(),
which checks if there is another event in the same location. If I needed to support multiple events at the same location, this invokation
must be deleted. 

- How would you change your program if you were working with a much larger world size? 
Answer: The program does not generates an object that contains x locations. This provides escalability, as there is no need to store
every location even though there is not any event in it. Thus, to change the world size, in the method getRandomLocation() that is used to
generate the location of an event, it would be enough with changing the range of values of the variables randomX and randomY (right now this
range is [-10,10]).

Example of execution:


Random data generated: 
Event 0 - Location: -1,-4. Cheapest ticket: $53.75
Event 1 - Location: 4,10. Cheapest ticket: $50.32
Event 2 - Location: -8,-9. Cheapest ticket: $56.92
Event 3 - Location: 7,0. Cheapest ticket: $58.73
Event 4 - Location: -8,10. Cheapest ticket: $60.79
Event 5 - Location: 3,6. Cheapest ticket: $58.11
Event 6 - Location: -7,-9. Cheapest ticket: $67.66
Event 7 - Location: 4,6. Cheapest ticket: $55.96
Event 8 - Location: 8,5. Cheapest ticket: $63.89
Event 9 - Location: 5,1. Cheapest ticket: $55.16
Please introduce your location: 
Coordenate x:
1
Coordenate y:
2
The five closer events to your location are:
Event 9 - Location: 5,1. Cheapest ticket: $55.16
Event 5 - Location: 3,6. Cheapest ticket: $58.11
Event 7 - Location: 4,6. Cheapest ticket: $55.96
Event 3 - Location: 7,0. Cheapest ticket: $58.73
Event 0 - Location: -1,-4. Cheapest ticket: $53.75
