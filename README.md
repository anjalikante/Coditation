# Coditation
Category And Product management
Below mentioned request bodies and responses of some api's

1) Add product:
 {
        "product_name": "Sony TV",
        "price": 15000,
        "category": {
            "id": 4
         }
        
}

2)Add Category(Parent category)
{
 	    "categoryName": "electronics"        
}

3) Add Category:(child category)
 {
 	    "categoryName": "TV",
        "parent": {
            "id": 1
         }
        
}


4)get all category api response
[
    {
        "id": 1,
        "categoryName": "electronics",
        "childCategories": [
            {
                "id": 3,
                "categoryName": "mobile",
                "childCategories": [],
                "productSet": [
                    {
                        "id": 3,
                        "product_name": "MI",
                        "price": 5000,
                        "category": 3
                    },
                    {
                        "id": 2,
                        "product_name": "nokia123",
                        "price": 5000,
                        "category": 3
                    },
                    {
                        "id": 1,
                        "product_name": "samsung",
                        "price": 1000,
                        "category": 3
                    }
                ]
            },
            {
                "id": 4,
                "categoryName": "TV",
                "childCategories": [],
                "productSet": [
                    {
                        "id": 6,
                        "product_name": "Sony TV",
                        "price": 15000,
                        "category": 4
                    }
                ]
            }
        ],
        "productSet": []
    },
    {
        "id": 2,
        "categoryName": "Home decor",
        "childCategories": [],
        "productSet": []
    },
    3,
    4,
    {
        "id": 5,
        "categoryName": "clothing",
        "childCategories": [],
        "productSet": []
    }
]



5)get product by category name response
[
    {
        "id": 1,
        "product_name": "samsung",
        "price": 1000,
        "category": null
    },
    {
        "id": 2,
        "product_name": "nokia123",
        "price": 5000,
        "category": null
    },
    {
        "id": 3,
        "product_name": "MI",
        "price": 5000,
        "category": null
    }
]

6)Update product request body
 {
 	"id":2,
        "product_name": "nokia123",
        "price": 5000,
        "category": {
            "id": 3
         }
        
}

7)get all products api response
[
    {
        "id": 1,
        "product_name": "samsung",
        "price": 1000,
        "category": null
    },
    {
        "id": 2,
        "product_name": "nokia123",
        "price": 5000,
        "category": null
    },
    {
        "id": 3,
        "product_name": "MI",
        "price": 5000,
        "category": null
    },
    {
        "id": 6,
        "product_name": "Sony TV",
        "price": 15000,
        "category": null
    }
]
