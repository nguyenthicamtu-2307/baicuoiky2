create database QLGym
go
use QLGym
go

create table tblKhoHang
(
	maHang varchar(10) primary key,
	tenHang nvarchar(50),
	loaiHang nvarchar(30),
	soLuong int,
	giaTien money
)

create table tblDonHang
(
	STT int identity primary key,
	maHang varchar(10),
	tenHang nvarchar(50),
	ngayMua date,
	soLuongMua int,
	thanhTien money,
	foreign key (maHang) references tblKhoHang(maHang)
)

create table tblThanhVien
(
	maThanhVien int identity primary key,
	tenThanhVien nvarchar(50),
	SDT varchar(10),
	diaChi nvarchar(50),
	trangThaiThe nvarchar(50),
	ngayDangKy date,
	thoiGianHieuLuc nvarchar(10),
	loaiThe nvarchar(20),
	loaiHinhThe nvarchar(20),
	tongTien money
)

go
create trigger tgInsertDonHang
on tblDonHang
after insert
as
begin
	update tblKhoHang
	set soLuong = soLuong - inserted.soLuongMua
	from inserted
	where tblKhoHang.maHang = inserted.maHang
end

create table tblLoaiHang
(
	ID int identity primary key,
	loaiHang nvarchar(50)
)

create table tblThietBi
(
	maTB varchar(50) primary key,
	tenTB nvarchar(50),
	ngayNhap date,
	thoiGianBaoHanh nvarchar(20),
	xuatXu nvarchar(50),
	tinhTrang nvarchar(50)
)