CREATE TABLE IF NOT EXISTS users (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    isActive bool NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS categories(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    categoryName varchar(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS activities(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    activityName varchar(255) NOT NULL UNIQUE,
    categoryId bigint DEFAULT NULL,
    FOREIGN KEY (categoryId) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS users_activities(
    id bigint primary key  auto_increment,
    userId bigint,
    activityId bigint,
    status varchar(255) NOT NULL,
    FOREIGN KEY (userId) REFERENCES users (id),
    FOREIGN KEY (activityId) REFERENCES activities (id)
);

CREATE TABLE IF NOT EXISTS users_activities_time(
    id bigint primary key  auto_increment,
    userId bigint,
    activityId bigint,
    dateStart datetime DEFAULT NULL,
    dateEnd datetime DEFAULT NULL,
    FOREIGN KEY (userId) REFERENCES users (id),
    FOREIGN KEY (activityId) REFERENCES activities (id)
);