create database if not exists campaign;

CREATE TABLE `campaign.campaigns` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `closed_at` date NOT NULL,
  `created_at` datetime NOT NULL,
  `favourite_team` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `started_at` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;