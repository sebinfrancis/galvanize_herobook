Herobook API
GC publishing wants to develop something new for the fans. Your team is working on a new application for fans to browse all the heroes and villains from the comics.

Your task is to develop the API specs and implement them using Spring Web.

Instructions
Create a new repository.
Share the link to your new repo with your group. One repo per group.
Submit your work below.
Use the acceptance criteria provided to build the technical spec for the heroes resource. Once completed, implement it. The spec should include a table of the URIs, methods and descriptions for each. It should also include examples of the expected requests and responses.

Hint: You do not have to follow the sequence of the A.C. as long as you accomplish them all at the end.

Personas
GC publishing expects the following user personas:

Name	Role
Visitor	A regular visitor who comes to view the heroes.
Note: roles are provided by the requester and trusted automatically by the server

Acceptance Criteria
Visitors

As a visitor, I can view all the heroes.

When I view all the heros
Then I can see names of all heros
As a visitor, I can see information about any individual hero so that I can see their stats.

Rule: Heroes have an image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.

Given I have the name of a hero
When I retreive the hero
Then I can view all the details for that hero

Given I have an incorrect hero name
When I retreive details for that hero
Then I receive a message that it doesn't exist
