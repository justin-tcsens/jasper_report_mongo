insert into vehicle (carplate_num,make,model,chassis_num,axles_num,tyre_num,roadtax_expiry,manufacture_year) values 
('JPM1575','NISSAN','ALMERA','A893837100AA0101709',2,4,'2023-06-25','2017'),
('WSC9542','PROTON','X50','B29701091UD10978201',2,4,'2023-08-01','2020'),
('VAA426','PROTON','X70','T66545613116544A122',2,4,'2023-11-25','2021'),
('MXA5587','HYUNDAI','KONA','F843864A348Y8546547',2,4,'2023-12-05','2022'),
('NAN5022','TOYOTA','CAMRY','J6546E4664Q67411687',2,4,'2023-07-04','2019'),
('DAC2275','HONDA','ACCORD','H5668I86468434824Q7',2,4,'2023-08-08','2020');

insert into summon (vehicle_id,serial_num,fine_amt,location_,officer_name) values
((select id from vehicle where carplate_num = 'VAA426'),'H001741349',100,'SELAYANG, MRR2.','TN. MOHD SYED'),
((select id from vehicle where carplate_num = 'VAA426'),'J001900141',150,'JLN AMPANG HILLIR, AMPANG.','TN. NAHARUDDIN'),
((select id from vehicle where carplate_num = 'DAC2275'),'H005549741',300,'JLN DAMANSARA, UPTOWN 1','TN. FIRDAUS JAAFAR'),
((select id from vehicle where carplate_num = 'NAN5022'),'C284567134',200,'SKESYEN 17, PETALING JAYA.','PN. NORITA'),
((select id from vehicle where carplate_num = 'WSC9542'),'A651841371',150,'SUBANG PARADE, SUBANG','PN. NURHAYATI'),
((select id from vehicle where carplate_num = 'DAC2275'),'B528718741',50,'TAMAN MELAWATI, KL.','TN. SHAMSUL'),
((select id from vehicle where carplate_num = 'NAN5022'),'G000168431',300,'WANGSA MAJU, KL.','TN. CHAN SIEW KIAT'),
((select id from vehicle where carplate_num = 'NAN5022'),'K000006477',250,'BATU CAVES, SELANGOR.','TN. PREVEEN A/L THIRUNADEN');
