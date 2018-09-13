/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.2.0.1.0

Source Server         : CS_REAL_PASSENGER_SERVICE
Source Server Version : 110200
Source Host           : 172.22.61.25:1521
Source Schema         : ANGELPASSERVICE

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-09-07 17:18:23
*/


-- ----------------------------
-- Table structure for TD_AMBDATA_HISTORY
-- ----------------------------
DROP TABLE "ANGELPASSERVICE"."TD_AMBDATA_HISTORY";
CREATE TABLE "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" (
"ID" NUMBER NOT NULL ,
"DATA" CLOB NULL ,
"ISSAVE" NUMBER(2) NOT NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TD_AMBDATA_HISTORY
-- ----------------------------
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('115', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:26:08', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('113', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:22:53', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('114', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:25:33', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('116', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:29:11', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('119', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:51:29', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('120', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>9999</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA9999</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Dec17</FSDT>
      <SODT>05Dec171805</SODT>
      <FLTY>试飞</FLTY>
      <FLIN>国际</FLIN>
	  <ACFT>777</ACFT>
	  <CURRENTSTATION>SHA</CURRENTSTATION>
      <TAFL>CA1235</TAFL>
      <TAID>2345678</TAID>
    </FLTR>
  </SCHD>
</MSG>
', '1', TO_DATE('2018-09-07 16:53:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-07 16:53:30', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('121', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>9999</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA9999</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Dec17</FSDT>
      <SODT>05Dec171805</SODT>
      <FLTY>试飞</FLTY>
      <FLIN>国际</FLIN>
	  <ACFT>777</ACFT>
	  <CURRENTSTATION>SHA</CURRENTSTATION>
      <TAFL>CA1235</TAFL>
      <TAID>2345678</TAID>
    </FLTR>
  </SCHD>
</MSG>
', '1', TO_DATE('2018-09-07 17:18:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-07 17:18:21', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('117', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:39:28', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('118', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:42:10', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" VALUES ('112', '<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>15555</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>hh</FLTY>
      <FLIN>aa</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>,<?xml version="1.0" encoding="UTF-8"?>

<MSG xmlns="http://www.travelsky.com/2006/dcsi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <META>
    <SNDR>AODB</SNDR>
    <SEQN>53443</SEQN>
    <DTTM>20170105005029</DTTM>
    <TYPE>SCHD</TYPE>
    <STYP>DNLD</STYP>
  </META>
  <SCHD>
    <RECS>1</RECS>
    <FLTR>
      <FLID>11111</FLID>
      <ALCD>CA</ALCD>
      <FLNO>CA1111</FLNO>
      <MVIN>D</MVIN>
      <FSDT>05Jan17</FSDT>
      <SODT>05Jan171505</SODT>
      <FLTY>？？?????????</FLTY>
      <FLIN>？？</FLIN>
      <TAFL></TAFL>
      <TAID>4383678</TAID>
      <CNCL></CNCL>
      <MFID></MFID>
      <MFFI></MFFI>
      <ROUT RTNO="1">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ROUT>
      <ERUT RTNO="1">
        <APCD>SZX</APCD>
        <SCDT>05Jan171505</SCDT>
        <SEDT></SEDT>
        <SADT></SADT>
      </ERUT>
      <ERUT RTNO="2">
        <APCD>PEK</APCD>
        <SCAT>05Jan171815</SCAT>
        <SEAT></SEAT>
        <SAAT></SAAT>
      </ERUT>
      <ACFT>A333</ACFT>
      <RENO>B5946</RENO>
      <CSFT>ZH1384</CSFT>
      <VIPP>0</VIPP>
      <ESTT></ESTT>
      <ACTT></ACTT>
      <STND></STND>
      <TRML>T3</TRML>
      <FTSS></FTSS>
      <ABFT></ABFT>
      <ABRS></ABRS>
    </FLTR>
  </SCHD>
</MSG>', '0', TO_DATE('2018-09-07 16:20:14', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for TD_FLT_PLAN_DYNAMIC
-- ----------------------------
DROP TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC";
CREATE TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" (
"FLID" NUMBER(19) NOT NULL ,
"ALCD" VARCHAR2(5 BYTE) NOT NULL ,
"FLNO" VARCHAR2(10 BYTE) NOT NULL ,
"MVIN" VARCHAR2(5 BYTE) NOT NULL ,
"FSDT" VARCHAR2(12 BYTE) NOT NULL ,
"SODT" VARCHAR2(12 BYTE) NOT NULL ,
"FLTY" VARCHAR2(10 BYTE) NOT NULL ,
"FLIN" VARCHAR2(10 BYTE) NOT NULL ,
"ACFT" VARCHAR2(10 BYTE) NOT NULL ,
"RENO" VARCHAR2(10 BYTE) NULL ,
"TAOP" VARCHAR2(10 BYTE) NULL ,
"TAFL" VARCHAR2(12 BYTE) NULL ,
"TAID" NUMBER(19) NULL ,
"TRML" VARCHAR2(5 BYTE) NULL ,
"MAXP" NUMBER(3) NULL ,
"CSOP" VARCHAR2(5 BYTE) NULL ,
"CSFT" VARCHAR2(40 BYTE) NULL ,
"ESTT" VARCHAR2(12 BYTE) NULL ,
"ACTT" VARCHAR2(12 BYTE) NULL ,
"GTDT" VARCHAR2(1000 BYTE) NULL ,
"CHKC" VARCHAR2(50 BYTE) NULL ,
"CNCL" VARCHAR2(15 BYTE) NULL ,
"DELYCODE" VARCHAR2(10 BYTE) NULL ,
"DELYSTRT" VARCHAR2(20 BYTE) NULL ,
"DELYDURA" VARCHAR2(20 BYTE) NULL ,
"CLDT" VARCHAR2(1000 BYTE) NULL ,
"BOTM" VARCHAR2(12 BYTE) NULL ,
"VIPP" NUMBER(3) NULL ,
"CURRENTSTATION" VARCHAR2(8 BYTE) NOT NULL ,
"DESTSTATION" VARCHAR2(8 BYTE) NULL ,
"DEPTSTATION" VARCHAR2(8 BYTE) NULL ,
"ERUT" VARCHAR2(50 BYTE) NULL ,
"PCOT" VARCHAR2(15 BYTE) NULL ,
"PCCT" VARCHAR2(15 BYTE) NULL ,
"COTM" VARCHAR2(15 BYTE) NULL ,
"CCTM" VARCHAR2(15 BYTE) NULL ,
"FTSS" VARCHAR2(50 BYTE) NULL ,
"IAST" VARCHAR2(50 BYTE) NULL ,
"IARS" VARCHAR2(500 BYTE) NULL ,
"FASS" VARCHAR2(50 BYTE) NULL ,
"ABST" VARCHAR2(50 BYTE) NULL ,
"ABRS" VARCHAR2(500 BYTE) NULL ,
"PLANARRDESTTM" VARCHAR2(15 BYTE) NULL ,
"EXPARRDESTTM" VARCHAR2(15 BYTE) NULL ,
"ACTARRDESTTM" VARCHAR2(15 BYTE) NULL ,
"UPDATETM" DATE NULL ,
"ISDEL" NUMBER(2) DEFAULT 0  NOT NULL ,
"ISCAL" NUMBER(2) DEFAULT 0  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."FLID" IS 'AODB 中的唯一 ID';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ALCD" IS '航空公司代码';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."FLNO" IS '航班号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."MVIN" IS '运行标识 A – Arrival/到达 D – Departure/离港';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."FSDT" IS '集成系统修正后的航班计划日期';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."SODT" IS '航班计划日期/时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."FLTY" IS '航班类型如正班，试飞，补班等';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."FLIN" IS '航班标识(国内，国际，地区，混合)';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ACFT" IS '航班使用的机型';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."RENO" IS '航班注册号或尾号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."TAOP" IS '离开当前机场时起降匹配连接航班的承运人';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."TAFL" IS '关联航班航班号(对于到港航班，指下接飞；对于离港航班，指上接飞)';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."TAID" IS '关联航班航班的 AODB ID(对于到港航班，指下接飞；  对于离港航班，指上接飞)';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."TRML" IS '航班航站楼';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."MAXP" IS '该航班最大载客数';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."CSOP" IS '共享航班承运人代码';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."CSFT" IS '共享航班号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ESTT" IS '航班预计时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ACTT" IS '航班实际时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."GTDT" IS '登机门相关信息';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."CHKC" IS '值机柜台号集';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."CNCL" IS '取消日期时间。仅在航班取消时出现';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."DELYCODE" IS '延误码';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."DELYSTRT" IS '延误开始时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."DELYDURA" IS '延误时间长度';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."CLDT" IS '传送转盘的相关信息';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."BOTM" IS '离港航班登机开始时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."VIPP" IS '航班的 VIP 旅客数';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."CURRENTSTATION" IS '当前航站';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."DESTSTATION" IS '终点站(离港航班信息)';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."DEPTSTATION" IS '始发站(进港航班信息)';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ERUT" IS '经停站点集';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."PCOT" IS '计划值机开始时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."PCCT" IS '计划值机关闭时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."COTM" IS '值机开始时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."CCTM" IS '值机关闭时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."FTSS" IS '内部航班状态';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."IAST" IS '内部航班异常状态';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."IARS" IS '内部航班异常原因';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."FASS" IS '外部航班状态';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ABST" IS '外部航班异常状态';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ABRS" IS '外部航班异常原因';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."PLANARRDESTTM" IS '（离港）计划到达目的站的时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."EXPARRDESTTM" IS '（离港）预计到达目的站的时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ACTARRDESTTM" IS '（离港）实际到达目的站的时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."UPDATETM" IS '更新时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ISDEL" IS '是否删除(1:删除0:不删除)';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC"."ISCAL" IS '是否取消(1:取消0:不取消)';

-- ----------------------------
-- Records of TD_FLT_PLAN_DYNAMIC
-- ----------------------------
INSERT INTO "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" VALUES ('9999', 'CA', 'CA9999', 'D', '05Dec17', '05Dec171805', '试飞', '国际', '777', null, null, 'CA1235', '2345678', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'cus', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '0');

-- ----------------------------
-- Table structure for TD_PASSENGER_TRIP
-- ----------------------------
DROP TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP";
CREATE TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" (
"PSRT_ID" NUMBER(19) NOT NULL ,
"PSRT_FLTNO" VARCHAR2(12 BYTE) NOT NULL ,
"PSRT_FLT_DATE" DATE NOT NULL ,
"PSRT_BOARDNO" VARCHAR2(6 BYTE) NOT NULL ,
"PSRT_CHN_NAME" VARCHAR2(30 BYTE) NULL ,
"PSRT_ENG_NAME" VARCHAR2(50 BYTE) NULL ,
"PSRT_CERTIFICATE_NO" VARCHAR2(50 BYTE) NOT NULL ,
"PSRT_SEATNO" VARCHAR2(10 BYTE) NOT NULL ,
"PSRT_GENDER" VARCHAR2(10 BYTE) NULL ,
"PSRT_CLASS" VARCHAR2(10 BYTE) NULL ,
"PSRT_DEPT" VARCHAR2(5 BYTE) NOT NULL ,
"PSRT_DEST" VARCHAR2(5 BYTE) NOT NULL ,
"PSRT_IS_ETIC_KET" VARCHAR2(3 BYTE) NULL ,
"PSRT_ET_NO" VARCHAR2(90 BYTE) NULL ,
"PSRT_GROUP" VARCHAR2(50 BYTE) NULL ,
"PSRT_FLT_SHARE" VARCHAR2(15 BYTE) NULL ,
"PSRT_FFFR" VARCHAR2(300 BYTE) NULL ,
"PSRT_CKISTATUS" VARCHAR2(10 BYTE) NULL ,
"PSRT_CKI_TIME" TIMESTAMP(6)  NULL ,
"PSRT_CHECK_TIME" TIMESTAMP(6)  NULL ,
"PSRT_CHECK_IS_PASS" VARCHAR2(3 BYTE) NULL ,
"PSRT_BOARDSTATUS" VARCHAR2(10 BYTE) NULL ,
"PSRT_PRA_EDI" VARCHAR2(3 BYTE) NULL ,
"PSRT_OP_TM" TIMESTAMP(6)  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_ID" IS '行程编号ID，自增主键';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_FLTNO" IS '航班号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_FLT_DATE" IS '航班日期';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_BOARDNO" IS '登机号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_CHN_NAME" IS '旅客中文名';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_ENG_NAME" IS '旅客英文名';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_CERTIFICATE_NO" IS '证件号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_SEATNO" IS '旅客座位号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_GENDER" IS '旅客性别';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_CLASS" IS '舱位信息';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_DEPT" IS '始发站三位码';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_DEST" IS '目的站三位码';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_IS_ETIC_KET" IS '是否为电子客票旅客 Y:是|N:否';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_ET_NO" IS '电子客票号码';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_GROUP" IS '团体旅客标识（所属团名称）';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_FLT_SHARE" IS '共享航班';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_FFFR" IS '常客信息';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_CKISTATUS" IS '值机状态';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_CKI_TIME" IS '值机时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_CHECK_TIME" IS '安检时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_CHECK_IS_PASS" IS '安检是否放行 Y:是|N:否';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_BOARDSTATUS" IS '登机状态';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_PRA_EDI" IS '联程旅客标识 Y:是|N:否';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_PASSENGER_TRIP"."PSRT_OP_TM" IS '操作时间';

-- ----------------------------
-- Records of TD_PASSENGER_TRIP
-- ----------------------------
INSERT INTO "ANGELPASSERVICE"."TD_PASSENGER_TRIP" VALUES ('1', 'CA1515', TO_DATE('2018-08-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'BD99', '张三', null, '1111111111', '28J', null, null, 'PEK', 'SHA', null, null, null, null, null, null, null, null, null, null, null, TO_TIMESTAMP(' 2018-08-03 07:34:30:060000', 'YYYY-MM-DD HH24:MI:SS:FF6'));
INSERT INTO "ANGELPASSERVICE"."TD_PASSENGER_TRIP" VALUES ('2', 'CA1515', TO_DATE('2018-08-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'BD18', '李四', null, '222222222', '24J', null, null, 'PEK', 'SHA', null, null, null, null, null, null, null, null, null, null, null, TO_TIMESTAMP(' 2018-08-03 07:35:51:008000', 'YYYY-MM-DD HH24:MI:SS:FF6'));

-- ----------------------------
-- Table structure for TD_SPE_SERVICE_BOOK
-- ----------------------------
DROP TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK";
CREATE TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" (
"BOOKID" NUMBER(19) NOT NULL ,
"REALNAME" VARCHAR2(25 BYTE) NOT NULL ,
"FLNO" VARCHAR2(10 BYTE) NOT NULL ,
"MVIN" VARCHAR2(5 BYTE) NOT NULL ,
"FLDATE" VARCHAR2(12 BYTE) NOT NULL ,
"PHONE" VARCHAR2(12 BYTE) NOT NULL ,
"TYPE" VARCHAR2(12 BYTE) NOT NULL ,
"STATUS" VARCHAR2(12 BYTE) NOT NULL ,
"BOOKDESCRIBE" VARCHAR2(500 BYTE) NULL ,
"BOOKPICURL" VARCHAR2(100 BYTE) NOT NULL ,
"QRCODECONTENT" VARCHAR2(50 BYTE) NULL ,
"AUDITDESCRIBE" VARCHAR2(500 BYTE) NULL ,
"OPERATORID" NUMBER(19) NULL ,
"UPDATETM" DATE NOT NULL ,
"ISDEL" VARCHAR2(2 BYTE) DEFAULT 0  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."BOOKID" IS '预订ID';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."REALNAME" IS '真实姓名';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."FLNO" IS '航班号';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."MVIN" IS 'A:入港服务 D:离港服务';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."FLDATE" IS '航班日期';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."PHONE" IS '手机号码';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."TYPE" IS '服务类型';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."STATUS" IS '预订状态（待审核WAITING_AD；审核不通过NOPASS；待使用WAITING_USE;已过期OVERDUE;已使用USED）';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."BOOKDESCRIBE" IS '申请特服详情描述';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."BOOKPICURL" IS '申请图片地址';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."QRCODECONTENT" IS '二维码内容';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."AUDITDESCRIBE" IS '审批描述';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."OPERATORID" IS '操作员ID';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."UPDATETM" IS '操作时间';
COMMENT ON COLUMN "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK"."ISDEL" IS '是否删除(1:删除0:不删除)';

-- ----------------------------
-- Records of TD_SPE_SERVICE_BOOK
-- ----------------------------
INSERT INTO "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" VALUES ('1', '徐永杰', 'CA1515', 'D', '2018-08-12', '18310780508', 'TYPE01', 'WAITING_AD', '111111', '/pic/url1', null, null, null, TO_DATE('2018-09-04 10:58:29', 'YYYY-MM-DD HH24:MI:SS'), '0');
INSERT INTO "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" VALUES ('2', '徐永杰', 'CA1515', 'A', '2018-08-12', '18310780508', 'TYPE01', 'WAITING_AD', '111111', '/pic/url1', null, null, null, TO_DATE('2018-09-04 10:58:55', 'YYYY-MM-DD HH24:MI:SS'), '0');

-- ----------------------------
-- Sequence structure for TD_AMBDATA_SEQ
-- ----------------------------
DROP SEQUENCE "ANGELPASSERVICE"."TD_AMBDATA_SEQ";
CREATE SEQUENCE "ANGELPASSERVICE"."TD_AMBDATA_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 122
 NOCACHE ;

-- ----------------------------
-- Sequence structure for TD_PASSENGER_TRIP_SEQ
-- ----------------------------
DROP SEQUENCE "ANGELPASSERVICE"."TD_PASSENGER_TRIP_SEQ";
CREATE SEQUENCE "ANGELPASSERVICE"."TD_PASSENGER_TRIP_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 3
 NOCACHE ;

-- ----------------------------
-- Sequence structure for TD_SPE_SERVICE_BOOK_SEQ
-- ----------------------------
DROP SEQUENCE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK_SEQ";
CREATE SEQUENCE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 3
 NOCACHE ;

-- ----------------------------
-- Indexes structure for table TD_AMBDATA_HISTORY
-- ----------------------------

-- ----------------------------
-- Checks structure for table TD_AMBDATA_HISTORY
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" ADD CHECK ("ISSAVE" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TD_AMBDATA_HISTORY
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_AMBDATA_HISTORY" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TD_FLT_PLAN_DYNAMIC
-- ----------------------------

-- ----------------------------
-- Checks structure for table TD_FLT_PLAN_DYNAMIC
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("FLID" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("ALCD" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("FLNO" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("MVIN" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("SODT" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("FLTY" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("FLIN" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("ACFT" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("CURRENTSTATION" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("FSDT" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("ISCAL" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD CHECK ("ISDEL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TD_FLT_PLAN_DYNAMIC
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_FLT_PLAN_DYNAMIC" ADD PRIMARY KEY ("FLID");

-- ----------------------------
-- Indexes structure for table TD_PASSENGER_TRIP
-- ----------------------------

-- ----------------------------
-- Triggers structure for table TD_PASSENGER_TRIP
-- ----------------------------
CREATE OR REPLACE TRIGGER "ANGELPASSERVICE"."TRG_TD_PASSENGER_TRIP" BEFORE INSERT ON "ANGELPASSERVICE"."TD_PASSENGER_TRIP" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE WHEN (NEW.PSRT_ID IS NULL)
BEGIN
SELECT TD_PASSENGER_TRIP_SEQ.NEXTVAL INTO :NEW.PSRT_ID FROM DUAL;
END;
-- ----------------------------
-- Checks structure for table TD_PASSENGER_TRIP
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_ID" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_FLTNO" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_FLT_DATE" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_BOARDNO" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_CERTIFICATE_NO" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_SEATNO" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_DEPT" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_DEST" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD CHECK ("PSRT_OP_TM" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TD_PASSENGER_TRIP
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_PASSENGER_TRIP" ADD PRIMARY KEY ("PSRT_ID");

-- ----------------------------
-- Indexes structure for table TD_SPE_SERVICE_BOOK
-- ----------------------------

-- ----------------------------
-- Checks structure for table TD_SPE_SERVICE_BOOK
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("BOOKID" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("REALNAME" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("FLNO" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("MVIN" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("FLDATE" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("PHONE" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("TYPE" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("BOOKPICURL" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("UPDATETM" IS NOT NULL);
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD CHECK ("ISDEL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TD_SPE_SERVICE_BOOK
-- ----------------------------
ALTER TABLE "ANGELPASSERVICE"."TD_SPE_SERVICE_BOOK" ADD PRIMARY KEY ("BOOKID");
