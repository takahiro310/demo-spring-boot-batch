CREATE TABLE `todo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` text,
  `body` text,
  `finished` boolean,
  PRIMARY KEY (`id`)
);
