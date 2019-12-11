create table KT_Appointment (
	appId LONG not null primary key,
	appDate DATE null,
	surgeryId LONG,
	visitorId LONG
);

create table KT_Schedule (
	scheduleId LONG not null primary key,
	surgeryId LONG,
	day INTEGER,
	hour INTEGER
);