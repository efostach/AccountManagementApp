# Functional Design

This is a console application, which provide CRUD operations for Account, Developer and Skill entities.

When a User creates a new Developer the system automatically creates an Account. The last one is linked with Developer by ID. Developer entity has reference to Account, known as a key.
Account and Developer has relation 1 to 1.
Account can't be deleted and contains title, additional information about Developer and current status.

Skill entity allows to assign personal soft/hard skills to a Developer. User can manage skills creating a new skill to assign for a Developer or deleting existing one. Developer store references to several skill by ID.

All entities are stored in corresponding files: account.txt, developer.txt, skill.txt.