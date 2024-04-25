create database website_giay
go
use website_giay
go
create table thuong_hieu (
	id uniqueidentifier primary key default newid(),
	ten_url_anh varchar(20) default null,
	ma varchar(20) unique,
	ten nvarchar(50) default null,
	ngay_them datetime default GETDATE(),
	trangthai int null
)
create table de_giay (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ten nvarchar(50) default null,
	ngay_them datetime default null,
	trangthai int null
)
create table loai_giay (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ten nvarchar(50) default null,
	ngay_them datetime default GETDATE(),
	trangthai int null
)
create table chat_lieu (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ten nvarchar(50) default null,
	ngay_them datetime default null,
	trangthai int null
)
create table giay (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ten nvarchar(200) default null,
	id_thuong_hieu uniqueidentifier,
	id_chat_lieu uniqueidentifier,
	id_de_giay uniqueidentifier,
	id_loai_giay uniqueidentifier,
	gioi_tinh int,
	mota nvarchar(255) null,
	ngay_nhap datetime default GETDATE(),
	trangthai int null,
	foreign key (id_thuong_hieu) references thuong_hieu(id),
	foreign key (id_chat_lieu) references chat_lieu(id),
	foreign key (id_de_giay) references de_giay(id),
	foreign key (id_loai_giay) references loai_giay(id)
)

create table mau_sac (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ten nvarchar(50) default null,
	ngay_them datetime default GETDATE(),
	trangthai int null
)
create table kich_co (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ten nvarchar(50) default null,
	ngay_them datetime default GETDATE(),
	trangthai int null
)
create table giay_chi_tiet (
	id uniqueidentifier primary key default newid(),
	id_giay uniqueidentifier,
	id_mau_sac uniqueidentifier,
	id_kich_co uniqueidentifier,
	so_luong_ton int default null,
	gianhap decimal,
	giaban decimal,
	gia_sau_khuyen_mai decimal,
	ngay_them datetime default GETDATE(),
	trangthai int null,
	foreign key (id_giay) references giay(id),
	foreign key (id_mau_sac) references mau_sac(id),
	foreign key (id_kich_co) references kich_co(id)
)
CREATE TABLE anh_giay(
    id uniqueidentifier primary key default newid(), -- id ảnh
	id_giay_chi_tiet uniqueidentifier,
	ten_anh NVARCHAR(50), -- tên của ảnh lưu dưới chuỗi của cloundinary
	FOREIGN KEY (id_giay_chi_tiet) REFERENCES giay_chi_tiet(id),
)
select * from anh_giay
create table chuc_vu (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ten nvarchar(50) default null,
	trangthai int null
)
create table nhan_vien (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	ho_ten nvarchar(50) default null,
	ngay_sinh date null,
	dia_chi nvarchar(255) null,
	xa nvarchar(250) default null,
	huyen nvarchar(50) default null,
	thanh_pho nvarchar(255) null,
	anh varchar(20) null,
	sdt nvarchar(15) null,
	email nvarchar(255) null,
	id_chuc_vu uniqueidentifier,
	mat_khau nvarchar(255) null,
	ngay_vao_lam datetime null,
	ngay_nghi_viec datetime null,
	trangthai int null,
	foreign key (id_chuc_vu) references chuc_vu(id),
)
create table khach_hang (
	id uniqueidentifier primary key default newid(),
	ma varchar(20) unique,
	avatar varchar(20) null,
	ho_ten nvarchar(50) default null,
	ngay_sinh date null,
	sdt nvarchar(15) null,
	email nvarchar(255) null,
	mat_khau nvarchar(255) null,
	ngay_tao datetime default GETDATE(),
	trangthai int null,
)

create table dia_chi (
	id uniqueidentifier primary key default newid(),
	ma nvarchar(50) default null,
	id_khach_hang uniqueidentifier,
	ten_nguoi_nhan nvarchar(250) default null,
	sdt_nguoi_nhan nvarchar(250) default null,
	xa nvarchar(250) default null,
	huyen nvarchar(50) default null,
	thanh_pho nvarchar(50) default null,
	ngay_them datetime default GETDATE(),
	trangthai int null,
	foreign key (id_khach_hang) references khach_hang(id)
)

--INSERT TABLE

INSERT INTO thuong_hieu (ten_url_anh, ma, ten, trangthai)VALUES ('url_anh_1', 'TH001', N'Thương hiệu 1', 1);
INSERT INTO thuong_hieu (ten_url_anh, ma, ten, trangthai)VALUES('url_anh_2', 'TH002', N'Thương hiệu 2', 1);
INSERT INTO thuong_hieu (ten_url_anh, ma, ten, trangthai)VALUES('url_anh_3', 'TH003', N'Thương hiệu 3', 1);
INSERT INTO thuong_hieu (ten_url_anh, ma, ten, trangthai)VALUES('url_anh_4', 'TH004', N'Thương hiệu 4', 1);
INSERT INTO thuong_hieu (ten_url_anh, ma, ten, trangthai)VALUES('url_anh_5', 'TH005', N'Thương hiệu 5', 1);
go
INSERT INTO chat_lieu (ma, ten, ngay_them, trangthai) VALUES ('CL001', N'Chất liệu 1', GETDATE(), 1);
INSERT INTO chat_lieu (ma, ten, ngay_them, trangthai) VALUES ('CL002', N'Chất liệu 2', GETDATE(), 1);
INSERT INTO chat_lieu (ma, ten, ngay_them, trangthai) VALUES ('CL003', N'Chất liệu 3', GETDATE(), 1);
INSERT INTO chat_lieu (ma, ten, ngay_them, trangthai) VALUES ('CL004', N'Chất liệu 4', GETDATE(), 1);
INSERT INTO chat_lieu (ma, ten, ngay_them, trangthai) VALUES ('CL005', N'Chất liệu 5', GETDATE(), 1);
go
INSERT INTO de_giay (ma, ten, ngay_them, trangthai) VALUES ('DG001', N'Đế giày 1', GETDATE(), 1);
INSERT INTO de_giay (ma, ten, ngay_them, trangthai) VALUES ('DG002', N'Đế giày 2', GETDATE(), 1);
INSERT INTO de_giay (ma, ten, ngay_them, trangthai) VALUES ('DG003', N'Đế giày 3', GETDATE(), 1);
INSERT INTO de_giay (ma, ten, ngay_them, trangthai) VALUES ('DG004', N'Đế giày 4', GETDATE(), 1);
INSERT INTO de_giay (ma, ten, ngay_them, trangthai) VALUES ('DG005', N'Đế giày 5', GETDATE(), 1);
go
INSERT INTO loai_giay (ma, ten, ngay_them, trangthai) VALUES ('LG001', N'Loại giày 1', GETDATE(), 1);
INSERT INTO loai_giay (ma, ten, ngay_them, trangthai) VALUES ('LG002', N'Loại giày 2', GETDATE(), 1);
INSERT INTO loai_giay (ma, ten, ngay_them, trangthai) VALUES ('LG003', N'Loại giày 3', GETDATE(), 1);
INSERT INTO loai_giay (ma, ten, ngay_them, trangthai) VALUES ('LG004', N'Loại giày 4', GETDATE(), 1);
INSERT INTO loai_giay (ma, ten, ngay_them, trangthai) VALUES ('LG005', N'Loại giày 5', GETDATE(), 1);

INSERT INTO kich_co (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'KC001', N'Size 1', GETDATE(), 1);
INSERT INTO kich_co (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'KC002', N'Size 2', GETDATE(), 1);
INSERT INTO kich_co (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'KC003', N'Size 3', GETDATE(), 1);
INSERT INTO kich_co (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'KC004', N'Size 4', GETDATE(), 1);
INSERT INTO kich_co (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'KC005', N'Size 5', GETDATE(), 1);

INSERT INTO mau_sac (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'MS001', N'Màu 1', GETDATE(), 1);
INSERT INTO mau_sac (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'MS002', N'Màu 2', GETDATE(), 1);
INSERT INTO mau_sac (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'MS003', N'Màu 3', GETDATE(), 1);
INSERT INTO mau_sac (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'MS004', N'Màu 4', GETDATE(), 1);
INSERT INTO mau_sac (id, ma, ten, ngay_them, trangthai) VALUES (NEWID(), 'MS005', N'Màu 5', GETDATE(), 1);

INSERT INTO chuc_vu (ma, ten, trangthai)VALUES ('CV001', 'Admin', 1);
INSERT INTO chuc_vu (ma, ten, trangthai)VALUES ('CV002', 'Nhân viên', 1);


--- Truy vấn
SELECT * FROM thuong_hieu
SELECT * FROM chat_lieu
SELECT * FROM de_giay
SELECT * FROM loai_giay
SELECT * FROM mau_sac
SELECT * FROM kich_co
SELECT * FROM giay
SELECT * FROM giay_chi_tiet
SELECT * FROM nhan_vien
SELECT * FROM chuc_vu
SELECT * FROM khach_hang
SELECT * FROM dia_chi
-- Delete