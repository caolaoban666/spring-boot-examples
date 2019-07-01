-- Create table
create table TB_LABEL_FORM_RELATION
(
  ID          VARCHAR2(64),
  LABLE_ID    VARCHAR2(64),
  FORM_ID     VARCHAR2(64),
  CREATE_TIME DATE,
  UPDATE_TIME DATE
)
tablespace ATS_ES
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );


insert into tb_label_form_relation (ID, LABLE_ID, FORM_ID, CREATE_TIME, UPDATE_TIME)
values ('2', '4', '1879', null, null);

insert into tb_label_form_relation (ID, LABLE_ID, FORM_ID, CREATE_TIME, UPDATE_TIME)
values ('1', '3', '1880', null, null);



