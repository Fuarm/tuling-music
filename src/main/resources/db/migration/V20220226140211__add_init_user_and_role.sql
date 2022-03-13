INSERT INTO `user` (id, username, nickname, password, created_time, updated_time)
VALUES ('1', 'admin', '超级管理员', '$2a$10$rZOt238E/ytNeWjCvuYtW.91Xy1Li8MP5WrDeVixSn2BNhG8E4e72',
        '2022-02-26 09:27:12.260000',
        '2022-02-26 09:27:12.260000');
INSERT INTO `role` (id, identify_code, name, created_time, updated_time)
VALUES ('1', 'ROLE_USER', '普通用户', '2022-02-26 09:27:12.260000', '2022-02-26 09:27:12.260000');
INSERT INTO `role` (id, identify_code, name, created_time, updated_time)
VALUES ('2', 'ROLE_ADMIN', '超级管理员', '2022-02-26 09:27:12.260000', '2022-02-26 09:27:12.260000');
INSERT INTO `user_role` (user_id, role_id)
VALUES ('1', '1');
INSERT INTO `user_role` (user_id, role_id)
VALUES ('1', '2');