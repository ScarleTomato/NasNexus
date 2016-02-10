USE [NasNexus]
GO

/****** Object:  Table [dbo].[Servers]    Script Date: 2/10/2016 2:39:26 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Servers](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[Address] [varchar](50) NULL,
	[Description] [nvarchar](255) NULL,
	[createdDate] [datetime] NOT NULL CONSTRAINT [DF_Servers_createdDate]  DEFAULT (getdate())
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


