CREATE TABLE memberDto (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_name VARCHAR(10),
                        user_last_name VARCHAR(5),
                        birth_day BIGINT,
                        email VARCHAR(50),
                        password VARCHAR(50)
);

INSERT INTO memberDto (user_name, user_last_name, birth_day, email, password)
VALUES ('luda', 'lee', 990412, 'rudaroy@naver.com', 'fnek0412');