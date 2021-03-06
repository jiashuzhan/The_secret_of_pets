USE [master]
GO
/****** Object:  Database [TheSecretOfPet]    Script Date: 2019/4/3 星期三 20:56:09 ******/
CREATE DATABASE [TheSecretOfPet]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TheSecretOfPet', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\TheSecretOfPet.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TheSecretOfPet_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\TheSecretOfPet_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TheSecretOfPet] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TheSecretOfPet].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TheSecretOfPet] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET ARITHABORT OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [TheSecretOfPet] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TheSecretOfPet] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TheSecretOfPet] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TheSecretOfPet] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TheSecretOfPet] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET RECOVERY FULL 
GO
ALTER DATABASE [TheSecretOfPet] SET  MULTI_USER 
GO
ALTER DATABASE [TheSecretOfPet] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TheSecretOfPet] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TheSecretOfPet] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TheSecretOfPet] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [TheSecretOfPet]
GO
/****** Object:  Table [dbo].[BusCompany]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BusCompany](
	[companyID] [int] NULL,
	[roadLineCount] [int] NULL,
	[busCount] [int] NULL,
	[driverCount] [int] NULL,
	[complainCount] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CompanyMessage]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CompanyMessage](
	[theme] [nvarchar](50) NOT NULL,
	[information] [nvarchar](200) NOT NULL,
	[reporter] [nvarchar](10) NOT NULL,
	[date] [date] NOT NULL,
	[id] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Customer]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[userName] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[nickName] [nvarchar](20) NOT NULL,
	[loginMethod] [nvarchar](10) NOT NULL,
	[email] [nvarchar](20) NOT NULL,
	[telephone] [nvarchar](15) NOT NULL,
	[longitude] [float] NOT NULL,
	[latitude] [float] NOT NULL,
	[location] [nvarchar](100) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Driver]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Driver](
	[userName] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[workerName] [nvarchar](10) NOT NULL,
	[workerSex] [int] NOT NULL,
	[workerYears] [int] NOT NULL,
	[healthExam] [int] NOT NULL,
	[petID] [nvarchar](10) NOT NULL,
	[telephone] [nvarchar](15) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DriverWorkInformation]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DriverWorkInformation](
	[userName] [nvarchar](20) NOT NULL,
	[petID] [nvarchar](10) NOT NULL,
	[lineID] [int] NOT NULL,
	[workStatus] [nvarchar](10) NOT NULL,
	[restTime] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Manager]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[userName] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[companyID] [int] NOT NULL,
	[managerName] [nvarchar](10) NOT NULL,
	[managerSex] [int] NOT NULL,
	[busCount] [int] NOT NULL,
	[driverCount] [int] NOT NULL,
	[telephone] [nvarchar](15) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Passenger]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Passenger](
	[passengerID] [int] IDENTITY(1,1) NOT NULL,
	[busID] [nvarchar](10) NOT NULL,
	[bodyTem] [float] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pet]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pet](
	[petID] [nvarchar](10) NOT NULL,
	[innerTem] [float] NOT NULL,
	[outerTem] [float] NOT NULL,
	[lightStrength] [float] NOT NULL,
	[petage] [int] NOT NULL,
	[status] [int] NOT NULL,
	[petType] [nvarchar](20) NOT NULL,
	[petkg] [int] NOT NULL,
	[workerName] [nvarchar](10) NOT NULL,
	[petname] [nchar](10) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PetInnerInformation]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PetInnerInformation](
	[petID] [nchar](10) NULL,
	[petStatus] [int] NULL,
	[roomTemperature] [float] NULL,
	[petTemperature] [float] NULL,
	[petLongitude] [float] NULL,
	[petLatitude] [float] NULL,
	[lightStrength] [float] NULL,
	[lightStatusOne] [int] NULL,
	[lightStatusTwo] [int] NULL,
	[lightStatusThree] [int] NULL,
	[lightStatusFour] [int] NULL,
	[petType] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RoadLine]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoadLine](
	[lineID] [int] NOT NULL,
	[lineName] [nvarchar](20) NOT NULL,
	[startStation] [nvarchar](10) NOT NULL,
	[endStation] [nvarchar](10) NOT NULL,
	[stationCount] [int] NOT NULL,
	[firstTime] [nvarchar](10) NOT NULL,
	[endTime] [nvarchar](10) NOT NULL,
	[busCount] [int] NOT NULL,
	[busInterval] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Station]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Station](
	[stationID] [int] NOT NULL,
	[stationName] [nvarchar](10) NOT NULL,
	[lineID] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tu]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tu](
	[username] [nvarchar](10) NOT NULL,
	[seven] [nvarchar](10) NOT NULL,
	[oneone] [nvarchar](10) NOT NULL,
	[onefive] [nvarchar](10) NOT NULL,
	[onenine] [nvarchar](10) NOT NULL,
	[twothree] [nvarchar](10) NOT NULL,
	[three] [nvarchar](10) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UpdateInformation]    Script Date: 2019/4/3 星期三 20:56:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UpdateInformation](
	[tableName] [nvarchar](10) NOT NULL,
	[updateTime] [date] NOT NULL
) ON [PRIMARY]

GO
INSERT [dbo].[BusCompany] ([companyID], [roadLineCount], [busCount], [driverCount], [complainCount]) VALUES (1, 10, 100, 100, 10)
INSERT [dbo].[BusCompany] ([companyID], [roadLineCount], [busCount], [driverCount], [complainCount]) VALUES (2, 6, 6, 7, 7)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【价格变动】', N'价格下调', N'李主管', CAST(0x003D0B00 AS Date), 1)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【路线变动】', N'218路线变动', N'王主管', CAST(0x003D0B00 AS Date), 2)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【线路变动】', N'202线路变动', N'liumou', CAST(0x003D0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【pdd】', N'123456', N'liumou', CAST(0xF43D0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【pdd】', N'kdajdka', N'liumou', CAST(0xF43D0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【pdd】', N'say good bye', N'liumou', CAST(0xF43D0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【changecoast】', N'888888', N'liumou', CAST(0x023E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【Change the 202 line】', N'change

', N'liumou', CAST(0x043E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【change line 202】', N'change the
 line
', N'liumou', CAST(0x053E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【change pay】', N'202line 4$', N'liumou', CAST(0x0D3E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【ddd】', N'ddd', N'liumou', CAST(0x1E3E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【123456】', N'123456', N'liumou', CAST(0x1E3E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【456456】', N'456456', N'liumou', CAST(0x1E3E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【505】', N'505', N'liumou', CAST(0x203E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【505duche】', N'505duche', N'liumou', CAST(0x203E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【505】', N'505', N'liumou', CAST(0x213E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【505】', N'505', N'liumou', CAST(0x213E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【506】', N'506', N'liumou', CAST(0x213E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【202 jam】', N'202 jam', N'liumou', CAST(0x303E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【505 jam】', N'505 jam', N'liumou', CAST(0x473E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【202 jam】', N'202 jam', N'liumou', CAST(0x473E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【 101 jam】', N'101 jam', N'liumou', CAST(0x473E0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【    pets so cute】', N'cute cute cute', N'', CAST(0x1F3F0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【lllllllll】', N'lllllllllllllllll', N'', CAST(0x203F0B00 AS Date), 6)
INSERT [dbo].[CompanyMessage] ([theme], [information], [reporter], [date], [id]) VALUES (N'【jjjjjjj】', N'jjjjjjjjjjjj', N'', CAST(0x203F0B00 AS Date), 6)
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'zhangsan', N'123456', N'sansan', N'email', N'zhangsan@qq.com', N'15157899874', 10, 10, N'thisLocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'wangwu', N'987654', N'wuwu', N'email', N'wangwu@163.com', N'15157889457', 100, 100, N'thisLocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'zhaoliu', N'654789', N'liuliu', N'email', N'zhaoliu@163.com', N'15157842154', 200, 200, N'thisLocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'dingqi', N'987654', N'qiqi', N'email', N'dingqi@163.com', N'15158965412', 300, 300, N'thisLocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'jack', N'87998937', N'lilu', N'Email', N'123456@qq.com', N'15697583240', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'bill', N'8976509', N'lucy', N'Email', N'123456@163.com', N'13362726352', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'lina', N'905825763', N'nancy', N'Email', N'545462@163.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'yasuo', N'9870654', N'luna', N'Email', N'13256@163.com', N'15157236148', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'qwer', N'2312455', N'taiseng', N'Email', N'13568974@qq.com', N'15685236547', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'vn', N'879i8937', N'bick', N'Email', N'1545@qq.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'nick', N'98799u', N'his', N'Email', N'china@qq.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'niko', N'876889', N'koko', N'Email', N'jisjsj@qq.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'coco', N'6tr86787', N'nke', N'Email', N'qwedff@qq.com', N'15688359254', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'lixi', N'9879866', N'nick', N'Email', N'ieyue@qq.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'jilu', N'87998978', N'nick', N'Email', N'gdhsh@qq.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'candy', N'87998937', N'nick', N'Email', N'58497@163.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'Bob', N'87733', N'nunu', N'Email', N'854799@163.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'nunu', N'87733rhrhhrrh', N'nunu', N'Email', N'854799@163.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Customer] ([userName], [password], [nickName], [loginMethod], [email], [telephone], [longitude], [latitude], [location]) VALUES (N'李娜', N'879999', N'小王', N'Email', N'hdhdhhddn@qq.com', N'15157265612', 0, 0, N'thislocation')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'shuzhan', N'123456', N'xiaoming', 1, 5, 1, N'123456789', N'15158955478')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'dingding', N'741852', N'dingding', 2, 3, 1, N'987654321', N'15154788745')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'lucy', N'111111', N'lucy', 2, 2, 1, N'963852741', N'15157844856')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'shuzhan', N'123456', N'shuahan', 0, 0, 0, N'123', N'17858263951')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'wyt', N'123456', N'wyt123', 0, 0, 0, N'123', N'1711')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'dazhanye', N'123456', N'lll', 0, 0, 0, N'123', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'csz', N'123456', N'sss', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'bigzhan', N'123456', N'llllll', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'9999', N'123', N'111', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'11111', N'123456', N'1', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'dadada', N'123456', N'wyt', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'998', N'123', N'12222', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'csz1', N'123456', N'haha', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'csz3', N'123456', N'12345', 0, 0, 0, N'123456789', N'111')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'csz5', N'123456', N'1113', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'wyt123', N'123456', N'12333', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'wyt12', N'123456', N'kjjj', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'wyt9', N'123456', N'12345699', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'998123', N'123456', N'kasdkja', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'happy', N'123456', N'120', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'happy1', N'123456', N'happy', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'happy2', N'123456', N'happy2', 0, 0, 0, N'123456789', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'shuzzz', N'123456', N'wowow', 0, 0, 0, N'783356', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'sss1', N'123456', N'shuzhan', 0, 0, 0, N'9191', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'sss2', N'123', N'999', 0, 0, 0, N'9192', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'sss4', N'123', N'111', 0, 0, 0, N'888', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'haha', N'123456', N'111', 0, 0, 0, N'123', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'sss3', N'123', N'shuzhan', 0, 0, 0, N'9193', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'shuzhanda', N'123456', N'shushu', 0, 0, 0, N'103393', N'17858263951')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'shuzhan9', N'123456', N'shuzhan9', 0, 0, 0, N'110', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'shuzhan11', N'123456', N'000', 0, 0, 0, N'102', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'sss5', N'123', N'1', 0, 0, 0, N'777', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'ss9', N'123', N'1', 0, 0, 0, N'767', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'zhan1', N'123', N'112', 0, 0, 0, N'09', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'zhan2', N'123', N'5', 0, 0, 0, N'10', N'1')
INSERT [dbo].[Driver] ([userName], [password], [workerName], [workerSex], [workerYears], [healthExam], [petID], [telephone]) VALUES (N'liuxiang', N'123', N'wuwu', 0, 0, 0, N'789', N'12')
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'shuzhan', N'123456789', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'dingding', N'987654321', 218, N'工作中', 10)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'lucy', N'963852741', 202, N'工作中', 7)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'csz', N'123456789', 111, N'不知道', 6)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'haha', N'123', 111, N'bzd', 2)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'shuzhan9', N'110', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'shuzhan11', N'102', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'sss1', N'9191', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'sss2', N'9192', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'sss3', N'9193', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'sss4', N'888', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'sss5', N'777', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'ss9', N'767', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'zhan1', N'09', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'zhan2', N'10', 202, N'工作中', 5)
INSERT [dbo].[DriverWorkInformation] ([userName], [petID], [lineID], [workStatus], [restTime]) VALUES (N'liuxiang', N'789', 202, N'工作中', 5)
INSERT [dbo].[Manager] ([userName], [password], [companyID], [managerName], [managerSex], [busCount], [driverCount], [telephone]) VALUES (N'pdd', N'666666', 1, N'liumou', 1, 20, 20, N'15158978965')
INSERT [dbo].[Manager] ([userName], [password], [companyID], [managerName], [managerSex], [busCount], [driverCount], [telephone]) VALUES (N'white', N'741852', 2, N'55kai', 1, 20, 15, N'15157889874')
SET IDENTITY_INSERT [dbo].[Passenger] ON 

INSERT [dbo].[Passenger] ([passengerID], [busID], [bodyTem]) VALUES (1, N'123456789', 37)
INSERT [dbo].[Passenger] ([passengerID], [busID], [bodyTem]) VALUES (2, N'123456789', 36)
SET IDENTITY_INSERT [dbo].[Passenger] OFF
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'123456789', 25, 35, 200, 10, 1, N'1', 30, N'zhangsan', NULL)
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'987654321', 25, 38, 500, 20, 1, N'1', 30, N'lisi', NULL)
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'123', 27, 31, 50, 1, 1, N'dog', 0, N'bigbai', NULL)
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'783356', 27, 31, 50, 1, 1, N'cat', 0, N'bai', NULL)
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'110', 27, 31, 50, 1, 1, N'dog', 0, N'shuzhan9', NULL)
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'102', 27, 31, 50, 1, 1, N'dog', 0, N'shuzhan11', NULL)
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'9193', 27, 31, 50, 5, 1, N'cat', 12, N'sss3', N'小白        ')
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'888', 27, 31, 50, 6, 1, N'dog', 10, N'sss4', N'小白        ')
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'777', 27, 31, 50, 7, 1, N'dog', 10, N'sss5', N'小白        ')
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'767', 27, 31, 50, 5, 1, N'2', 87, N'sadasd', N'小白        ')
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'09', 27, 31, 50, 12, 1, N'1', 1, N'zhan1', N'小白        ')
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'10', 27, 31, 50, 22, 1, N'1', 3, N'zhan2', N'小白        ')
INSERT [dbo].[Pet] ([petID], [innerTem], [outerTem], [lightStrength], [petage], [status], [petType], [petkg], [workerName], [petname]) VALUES (N'789', 27, 31, 50, 5, 1, N'1', 5, N'liuxiang', N'小白        ')
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'123456789 ', 0, 18, 18, 1210, 0, 1075, 0, 1, 1, 1, 1)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'123       ', 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, NULL)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'783356    ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, NULL)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'110       ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, NULL)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'102       ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, NULL)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'9191      ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, NULL)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'9192      ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, NULL)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'9193      ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, NULL)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'777       ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, 1)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'10        ', 1, 27, 31, 0, 0, 0, 1, 1, 1, 1, 1)
INSERT [dbo].[PetInnerInformation] ([petID], [petStatus], [roomTemperature], [petTemperature], [petLongitude], [petLatitude], [lightStrength], [lightStatusOne], [lightStatusTwo], [lightStatusThree], [lightStatusFour], [petType]) VALUES (N'789       ', 1, 27, 31, 0, 0, 0, 0, 0, 0, 0, 1)
INSERT [dbo].[RoadLine] ([lineID], [lineName], [startStation], [endStation], [stationCount], [firstTime], [endTime], [busCount], [busInterval]) VALUES (202, N'台州学院-市区', N'台州学院', N'台州学院', 30, N'6:00', N'18:00', 20, 20)
INSERT [dbo].[RoadLine] ([lineID], [lineName], [startStation], [endStation], [stationCount], [firstTime], [endTime], [busCount], [busInterval]) VALUES (218, N'崇和门-海山公园', N'崇和门', N'崇和门', 11, N'6:00', N'18:00', 10, 10)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (1, N'台州学院', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (2, N'绿化', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (3, N'三峰路口', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (4, N'大洋社区', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (5, N'职教中心', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (6, N'市一医院', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (7, N'办事大厅', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (8, N'临海小学', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (9, N'客运中心', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (10, N'耀达大厦', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (11, N'耀达雍怡广场', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (12, N'小商品城', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (13, N'东湖公园', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (14, N'耀达商场', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (15, N'台州宾馆', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (16, N'中心菜场', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (17, N'中意宾馆', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (18, N'国贸宾馆', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (19, N'新江路口', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (20, N'巾山小区', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (21, N'柏叶西路', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (22, N'客运中心', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (23, N'花街工业园', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (24, N'办事大厅', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (25, N'市一医院', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (26, N'职教中心', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (27, N'大洋社区', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (28, N'三峰路口', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (29, N'绿化', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (30, N'台州学院', 202)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (31, N'崇和门', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (32, N'新客站', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (33, N'三峰', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (34, N'法轮寺', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (35, N'桃渚城址', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (36, N'海山公园', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (37, N'桃渚城址', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (38, N'法轮寺', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (39, N'三峰', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (40, N'新客站', 218)
INSERT [dbo].[Station] ([stationID], [stationName], [lineID]) VALUES (41, N'崇和门', 218)
INSERT [dbo].[Tu] ([username], [seven], [oneone], [onefive], [onenine], [twothree], [three]) VALUES (N'shuzhan', N'35.5', N'36.1', N'37.2', N'35.2', N'35.5', N'36')
INSERT [dbo].[Tu] ([username], [seven], [oneone], [onefive], [onenine], [twothree], [three]) VALUES (N'liuxiang', N'34.7', N'34.9', N'34', N'34', N'36', N'37')
INSERT [dbo].[UpdateInformation] ([tableName], [updateTime]) VALUES (N'Customer', CAST(0x1D3D0B00 AS Date))
INSERT [dbo].[UpdateInformation] ([tableName], [updateTime]) VALUES (N'worker', CAST(0xFE3C0B00 AS Date))
INSERT [dbo].[UpdateInformation] ([tableName], [updateTime]) VALUES (N'Manager', CAST(0xFE3C0B00 AS Date))
INSERT [dbo].[UpdateInformation] ([tableName], [updateTime]) VALUES (N'pet', CAST(0xFE3C0B00 AS Date))
ALTER TABLE [dbo].[CompanyMessage] ADD  DEFAULT ((-1)) FOR [id]
GO
USE [master]
GO
ALTER DATABASE [TheSecretOfPet] SET  READ_WRITE 
GO
