

create user chatuser with password 'chatting';
create user statisticuser with password 'ihatestatistics';

create schema chat authorization chatuser;
create schema statistic authorization statisticuser;

