

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, 'ADMIN');
INSERT INTO `roles` VALUES (2, 'GUEST');
INSERT INTO `roles` VALUES (3, 'HR');
INSERT INTO `roles` VALUES (4, 'HR-IMPORT');
INSERT INTO `roles` VALUES (5, 'HR-CALLING');
INSERT INTO `roles` VALUES (6, 'TRM');
INSERT INTO `roles` VALUES (7, 'QC-LEAD');
INSERT INTO `roles` VALUES (8, 'QC-CTV');
INSERT INTO `roles` VALUES (9, 'MKT-ADMIN');

-- ----------------------------
-- Records of privileges
-- ----------------------------
INSERT INTO `privileges` VALUES (1, 'CREATE');
INSERT INTO `privileges` VALUES (2, 'VIEW');
INSERT INTO `privileges` VALUES (3, 'UPDATE');
INSERT INTO `privileges` VALUES (4, 'DELETE');
INSERT INTO `privileges` VALUES (5, 'VIEW_ALL');
INSERT INTO `privileges` VALUES (6, 'UPDATE_ALL');
INSERT INTO `privileges` VALUES (7, 'DELETE_ALL');

-- ----------------------------
-- Records of role_privilege
-- ----------------------------
INSERT INTO `role_privilege` VALUES (1, 1, 1);
INSERT INTO `role_privilege` VALUES (2, 2, 1);
INSERT INTO `role_privilege` VALUES (3, 3, 1);
INSERT INTO `role_privilege` VALUES (4, 4, 1);
INSERT INTO `role_privilege` VALUES (5, 5, 1);
INSERT INTO `role_privilege` VALUES (6, 6, 1);
INSERT INTO `role_privilege` VALUES (7, 7, 1);
INSERT INTO `role_privilege` VALUES (8, 1, 3);
INSERT INTO `role_privilege` VALUES (9, 2, 3);
INSERT INTO `role_privilege` VALUES (10, 3, 3);
INSERT INTO `role_privilege` VALUES (11, 4, 3);
INSERT INTO `role_privilege` VALUES (12, 5, 3);

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '2019-12-27 15:20:30.000000', 'quanbh1@topica.edu.vn', 'quanbh1', 1);
INSERT INTO `users` VALUES (2, '2019-12-27 15:20:53.000000', 'quanbh2@topica.edu.vn', 'quanbh2', 1);
INSERT INTO `users` VALUES (3, '2019-12-27 15:22:15.000000', 'quanbh3@topica.edu.vn', 'quanbh3', 1);
INSERT INTO `users` VALUES (4, '2019-12-27 15:22:35.000000', 'quanbh4@topica.edu.vn', 'quanbh4', 1);
INSERT INTO `users` VALUES (5, '2019-12-27 15:22:52.000000', 'quanbh5@topica.edu.vn', 'quanbh5', 1);


