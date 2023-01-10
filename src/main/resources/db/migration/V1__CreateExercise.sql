CREATE TABLE exercise
(
    id          serial  not null primary key,
    name       text    not null,
    description        text    not null,
    difficulty text    not null,
    muscle_group    text    not null
);

INSERT INTO exercise (name, description, difficulty,  muscle_group)
VALUES ('Bench press', 'just do it with your heart', 'hard',  'chest'),
       ('Squat', 'do it!', 'hard',  'legs');