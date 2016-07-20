# TW-cash
[![Build Status](https://travis-ci.org/Zhanglei-git/TW-cash.svg?branch=master)](https://travis-ci.org/Zhanglei-git/TW-cash)

![image](https://github.com/Zhanglei-git/CIproject/blob/master/UML.png)
1. load 商品信息 Goods 到 GoodsList（静态）<br/>
2. load 购买信息 ShoppingItem 到 ShoppingCart<br/>
3. Strategy接口包含根据策略计算相应价钱，不同优惠策略实现该接口；<br/>
   通过工厂方法StrategyFactory人为设置不同的优惠策略(工厂方法图中未画出)；<br/>
   店员根据优惠策略设置StrategyItem对象，其中包括策略优先级（优先考虑谁） 冲突标志（冲突的优惠，冲突标志相同），冲突时是否独占（即只考虑它）；<br/>
   将包含各种优惠策略的StrategyItem对象加入 List<StrategyItem> strategyList（静态）<br/>
4. 利用 ShoppingCart 构建支付对象 Payment<br/>
5. 调用 Payment 所提供的折后价计算方法计算优惠<br/>
   Payment. calculateAfterAllStrategy()说明:List<StrategyItem> strategyList 中所存储的优惠策略,计算优惠后价时输入输出均为 ShoppingCart;<br/>
   List<StrategyItem> strategyList中，所有优惠策略类似一个过滤器组,依次过滤 ShoppingCart将最后一个优惠策略过滤后的 ShoppingCart 进行最终价格计算；<br/>
   List<StrategyItem> strategyList中，先把所有策略按照优先级排序，检查所计算策略是否在优惠冲突时独占优惠，如果独占，则符合的商品在计算时，对于符合相同冲突标记的策略不予考虑，否则 继续叠加计算<br/>
6. Print接口包含打印清单方法，OrdinaryPrint实现该接口，传递ShoppingCart实现普通打印<br/>

