CREATE TABLE IF NOT EXISTS roles(
    id smallint PRIMARY KEY AUTO_INCREMENT,
    roleName VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    isActive bool NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS users_roles(
    userId bigint,
    roleId smallint,
    FOREIGN KEY (userId) REFERENCES users (id),
    FOREIGN KEY (roleId) REFERENCES roles (id)
);

CREATE TABLE IF NOT EXISTS categories(
    id int PRIMARY KEY AUTO_INCREMENT,
    categoryName varchar(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS statuses(
    id int primary key auto_increment,
    statusName varchar(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS activities(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    activityName varchar(255) NOT NULL,
    dateStart datetime NOT NULL,
    dateEnd datetime,
    categoryId int,
    FOREIGN KEY (categoryId) REFERENCES categories (id),
    statusId int references statuses,
    FOREIGN KEY (statusId) REFERENCES statuses (id)
);

CREATE TABLE IF NOT EXISTS users_activities(
    id bigint primary key  auto_increment,
    activityId bigint,
    activityOwner bigint,
    activityPerformer bigint,
    FOREIGN KEY (activityOwner) REFERENCES users (id),
    FOREIGN KEY (activityPerformer) REFERENCES users (id),
    FOREIGN KEY (activityId) REFERENCES activities (id)
);
