create
database academy;

use
academy;

create table Student_groups
(
    group_id   int primary key auto_increment not null,
    group_name varchar(45)
);

create table teachers
(
    teacher_id int primary key auto_increment not null,
    name       varchar(45),
    last_name  varchar(45),
    phone      varchar(45)
);

create table students
(
    student_id int primary key auto_increment not null,
    name       varchar(45),
    last_name  varchar(45),
    students_group_id   int not null,
    foreign key (students_group_id) references Student_groups (group_id)
);
