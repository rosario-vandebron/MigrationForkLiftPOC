# MigrationForkLiftPOC
A test project to test forklift and postgres

### Migrate the database

To run the migration script do the following:

- docker run some-postgres
- open sbt shell
- run ```mg init```
- run ```mg migrate```
- run ```mg apply```

### Add a new migration

To create a new migration
- run ```mg new d```
    - a new file is generated in ```migrations/src_migrations```
    - change it accordingly with the previous files
- run ```mg migrate```
- run ```mg apply```

Note: you have to commit and push the *generated code* as well

### Reset the database

to reset the database
- run ```mg reset```

