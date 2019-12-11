create index IX_FF15C690 on KT_Appointment (appDate);
create index IX_FBEC6711 on KT_Appointment (surgeryId);
create index IX_15FA09F7 on KT_Appointment (surgeryId, visitorId, appDate);
create index IX_BF2C450A on KT_Appointment (visitorId);

create index IX_8211126D on KT_Schedule (surgeryId);