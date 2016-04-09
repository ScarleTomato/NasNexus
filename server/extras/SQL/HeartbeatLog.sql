USE [NasNexus]
GO

/****** Object:  Table [dbo].[HeartbeatLog]    Script Date: 2/10/2016 9:47:33 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[HeartbeatLog](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[LogDate] [datetime] NOT NULL CONSTRAINT [DF_Table_1_logDate]  DEFAULT (getdate()),
	[ServerId] [bigint] NOT NULL,
	[VisibleIP] [varchar](50) NOT NULL,
 CONSTRAINT [PK_HeartbeatLog] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


