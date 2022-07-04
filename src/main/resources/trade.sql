--- 客户基础信息
select * from custinfo where mobileno  ='17600000001';
select * from custinfo where mobileno  ='17666100076';

select availablydate , * from custinfoex where custno ='1001883979';
select * from identitycardattachment i  where custno ='1001883979';
-- 第一次购买需要合格投资者认弹框
select * from pf_qualifiedinvestor pq    where custno ='1001883979' and authtype ='1';
-- 私募合格投资者认证
select * from pf_qualifiedinvestor pq    where custno ='1001883979';
select * from pf_qualifiedinvestor_detail pqd    where custno ='1001883979';
-- 风险等级
select * from custrisklevel c     where custno ='1001883979';



----自选信息
select * from  cust_optional_fund cof where custno ='1001883979';
select * from  cust_optional_group cog  where custno ='1001883979';


-- 交易相关的
-- 公募 投顾
select * from traderequest t  where custno ='1001883979';
select * from traderequest_status  t  where custno ='1001883979';
select * from v_traderequest_with_status vtws    where custno ='1001883979';
select * from v_traderequest30_with_status vtws  where custno ='1001883979';
-- 根据交易申请表造持仓数据：
select * from cq_insert_or_update_fundbalance('000709','20220529','1001883979' ,'1001546455');
-- 删除 mongodb 数据
select * from  amqp.publish("PKG_GLOBALS"."CONST_BROKERID"(), 'tradeapply_exchange', '', 'traderequest|202207011509393371100007|delete');
--  归历史
select *from  public.traderequest_to_history('202207011521263376100007');

-- 私募 start --
select * from pf_traderequest t  where custno ='1001883979';
select * from pf_traderequest_status  t  where custno ='1001883979';
select * from v_pf_traderequest_with_status vptws  where custno ='1001883979';
select *from  public.traderequest_to_history('202207011410143361100007')

-- 根据交易申请表造持仓数据：
select * from cq_insert_or_update_pf_fundbalance('D30034','20220529','1001883979' ,'1001546455');
--历史表
select * from v_h_pf_traderequest_with_status vhptws  where custno ='1001883979';
-- 侧袋资金 APKIND = '898' RETCODE = '0000'
select * from pf_acktradeblotter_sidebag;

-- 私募 end ---


-- 持仓信息
select* from tradeaccoinfo t  where custno ='1001883979';
select* from fundbalance f  where custno ='1001883979';
-- 游标查询
begin
select * from oqp_get_ebalanceandprofit_to_cache('1001883979');
fetch all in "<unnamed portal 4>";
end



cq_insert_or_update_fundbalance(pi_fundid, pi_workdate, pi_custno, pi_tradeacco)

发送mq消息，刷新mongo的份额集合
select OBP_CACHE_SINGLE_UPD_SEND('fundbalance', '1001882144');


-- 私募产品是否可以购买 zltype = ZLTOP  ('0','1','6') THEN '1'
select * from fundinfo f  where fundid ='SEW390';
-- 1: 高端私募预约    2: 质押宝预约
select * from  convert_config a where a.converttype='1'  and a.status ='N' and ='SEW390';


select * from merchant m  where partnerno != '1000';
select * from partner p ;





