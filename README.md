# WeeDooGift

## Get Balance of user : 

GET localhost:8083/weedoogift/user/{userId}/balance

## Add gift/meal to user from company :

POST

localhost:8083/weedoogift/company/{companyId}/user/{userId}/gift
localhost:8083/weedoogift/company/{companyId}/user/{userId}/meal

with body :

{
    "amount":"100"
}