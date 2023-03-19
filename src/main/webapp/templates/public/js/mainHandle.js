function loadCartData(data){
    let listProduct = Object.keys(data);
    $(".cart-list").html('');
    let totalItems = 0
    let subTotal = 0;
    listProduct.forEach(element => {
        let product = JSON.parse(element);
        totalItems += data[element];
        subTotal += parseInt(product.price.replaceAll(".","")) * data[element];
        $(".cart-list").append('<div class="product-widget" style="margin: 0 0 5px 0;border-bottom: 1px solid #cfcfcf;"> ' +
            '<div class="product-img" style="top: 30px">' +
            ' <img src="/templates/public/img/total_category/'+ product.id +'/1.jpg" alt="'+product.name+'">' +
            ' </div> ' +
            '<div class="product-body">' +
            ' <h3 class="product-name" style="height: 15px; display: inline;">' +
            '<a href="/ProductDetail?id="'+product.id+'>'+product.name+'</a>' +
            '</h3> ' +
            '<h4 class="product-price" style="margin: 0 0 5px 0;">' +
            '<span class="qty">'+data[element]+' x</span>'+product.price+' VNĐ</h4> ' +
            '</div> <button class="delete '+product.id+'" >' +
            '<i class="fa fa-close"></i></button> </div>');
    })
    var editSub = subTotal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    $("#qty-cart").text(totalItems);
    $("#amount-product").text(totalItems + (totalItems > 1 ? " item(s)" : " item") + " selected");
    $("#sub-total").text("SUBTOTAL: " + editSub + " VNĐ");
}

$(document).ready(function () {
    function getListProduct(position, category) {
        $.ajax({
            url: "/ListProduct",
            method: "POST",
            data: {"category": category, type: position},
            dataType: "JSON",
            success: function (response) {
                newProduct(position, response.Product);
            }
        })
    }

    function newProduct(position, listProduct) {
        for (let i = 0; i < $("." + position + "-product-img").length; i++) {
            let id = listProduct[i % listProduct.length].id;
            $("." + position + "-product-body .product-name a").eq(i).attr("href", "/ProductDetail?id=" + listProduct[i % listProduct.length].id);
            $("." + position + "-product-body .product-name a").eq(i).text(listProduct[i % listProduct.length].name);
            $("." + position + "-product-body .quick-view a").eq(i).attr("href", "/ProductDetail?id=" + listProduct[i % listProduct.length].id);
            $("." + position + "-product-img img")[i].src = "/templates/public/img/total_category/" + listProduct[i % listProduct.length].id + "/" + listProduct[i % listProduct.length].image;
            $("." + position + "-product-body .product-price").eq(i).text(listProduct[i % listProduct.length].price + " VNĐ")
            $("." + position + "-product-body ").eq(i).find(".add-to-cart-btn").attr("class","add-to-cart-btn " +id);
            if (position !== "suggestion") {
                $("." + position + "-product-img").eq(i).css({"height": "200px","margin-top": "10px"});
                $("." + position + "-product-img img").eq(i).css({"max-height": "100%","position":"absolute","bottom":"0","padding":"10px"});
                $("." + position + "-product-body .product-price").eq(i).css({"margin": "10px"});
            } else {
                $("." + position + "-product-body h3").eq(i).css({"height": "40px", "max-height": "40px"});
                $("." + position + "-product-body").eq(i).css({"margin": "0 0 80px 0"});
            }
        }
    };
    getListProduct("new", "Computers & Laptops");
    $("#category-list-new-product").click(event => {
        getListProduct("new", event.target.text)
    });
    getListProduct("top-selling", "Computers & Laptops");
    $("#category-list-top-selling").click(event => {
        getListProduct("top-selling", event.target.text)
    });
    getListProduct("suggestion", "");
    $(".quick-view").each(function () {
        $(this).click(function () {
            window.location.href += $(this).find("a").attr("href");
        })
    })
    function addCart(event){
            let quantity;
            let id =event.attr("class").split(" ")[1];
            if (event.siblings().find("input").val() !== undefined){
                quantity =event.siblings().find("input").val();
            }
            else {
                quantity = 1;
            }
            $.ajax({
                url: '/Cart',
                method: 'POST',
                dataType: "JSON",
                data: {
                    type: "add-cart",
                    productID: id,
                    quantity: quantity
                },
                success: function(data){
                    loadCartData(data);
                },
                error: function (){
                    alert("You need to login first!!!")
                }
            });
    }
    $(".add-to-cart-btn").click(function (){
        addCart($(this));
        console.log("hehe"+this);
    });
    $("#store").click(function (){
        if (event.target.classList.contains("add-to-cart-btn")){
            addCart($(event.target));
        }
    })
    $(".cart-dropdown").click(function (event){
        let id = $(event.target).closest(".delete").attr("class").split(" ")[1];
        $.ajax({
            url: '/Cart',
            method: 'POST',
            dataType: "JSON",
            data: {
                type: "delete-cart",
                productID: id,
            },
            success: function(data){
                $(event.target).closest(".delete").remove();
                loadCartData(data);
            },
            error: function (){
                alert('Có lỗi xảy ra');
            }
        });
    })

    $(".product-remove").click(function (event){
        let id = $(this).closest("tr").attr("id");
        $.ajax({
            url: '/Cart',
            method: 'POST',
            dataType: "JSON",
            data: {
                type: "delete-cart",
                productID: id,
            },
            success: function(data){
                $(event.target).closest("tr").remove();
                loadCartData(data);
            },
            error: function (){
                alert('Có lỗi xảy ra');
            }
        });
    })
    $(document).on("change","td.product-quantity input", function(){
        let id = $(this).closest("tr").attr("id");
        let quantity = $(this).val();
        let price = $(this).closest(".product-quantity").siblings(".product-price").text()
        price = price.replaceAll(".","").replace("VNĐ","");
        price = parseInt(price) * parseInt($(this).val());
        $(this).closest(".product-quantity").siblings(".product-subtotal").text(price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") + " VNĐ");
        $.ajax({
            url: '/Cart',
            method: 'POST',
            dataType: "JSON",
            data: {
                type: "update-cart",
                productID: id,
                quantity: quantity
            },
            success: function(data){
                loadCartData(data);
            },
            error: function (){
                alert('Có lỗi xảy ra');
            }
        });
    })
    $('.form-group input').each(function(){
        if ($(this).val()) {
            $(this).css('background-color', '#F8F8F8');
        } else {
            $(this).css('background-color', 'white');
        }
    });
    $('.form-group input').each(function(){
        $(this).keyup(function(){
            if ($(this).val()) {
                $(this).css('background-color', '#F8F8F8');
            } else {
                $(this).css('background-color', 'white');
            }
        });
    });
    function searchProduct(type, listCategory, minPrice, maxPrice, page) {
        $.ajax({
            url: "/ListProduct",
            method: "GET",
            dataType: "JSON",
            data: {
                type: type,
                listCategory: listCategory,
                minPrice: minPrice,
                maxPrice: maxPrice,
                page: page
            },
            success: function (data) {
                handleSearch(data.Product);
            }
        })
    }

    function handleSearch(data) {
        $("#show-product").html('');
        data.forEach(element => {
            $("#show-product").append('<div class="col-md-4 col-xs-6"> <div class="product category-' + element.id +
                '"> <a href="/ProductDetail?id=' + element.id + '"> <div class="product-img store-img"> ' +
                '<img src="/templates/public/img/total_category/' + element.id + '/' + element.image + '" alt="' + element.name + '' +
                '"style="position: absolute; bottom: 0; max-height: 100%; padding:10px"> <div class="product-label"> </div> ' +
                '</div> <div class="product-body store-body"> <p class="product-category">' + element.category.category_name + '' +
                '</p> <h3 class="product-name"><a href="/ProductDetail?id=' + element.id + '">' + element.name + '</a> </h3> ' +
                '<h4 class="product-price" style="margin-top: 20px;">' + element.price + ' VNĐ</h4> <div class="product-rating" ' +
                'style="bottom: 5px"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> ' +
                '<i class="fa fa-star"></i> <i class="fa fa-star"></i> </div> </div> <div class="add-to-cart"> <button ' +
                'class="add-to-cart-btn ' + element.id + '"><i class="fa fa-shopping-cart"></i> add to cart </button> </div> </a> </div> </div>')
        })
    }

    function checkCategory(minPrice, maxPrice, page) {
        var list = [];
        $(".input-checkbox label").each(function () {
            if ($(this).hasClass("checked")) {
                list.push($(this).text().trim());
            } else {
                list.push("");
            }
        });
        searchProduct("search", list, minPrice, maxPrice, page);
    }

    $(".input-checkbox label").on("click", function () {
        if (!$(this).hasClass("checked")) {
            $(this).addClass("checked");
        } else {
            $(this).removeClass("checked");
        }
        checkCategory($("#price-min").val(), $("#price-max").val(), 1)
        let count = 1;
        let page = parseInt($(this).text());
        $(".store-pagination li").each(function () {
            $(this).text(count);
            count += 1;
        })
    })
    var priceSlider = document.getElementById('price-slider');
    priceSlider.noUiSlider.on('update', function (values, handle) {
        checkCategory(values[0], values[1], 1);
        let count = 1;
        let page = parseInt($(this).text());
        $(".store-pagination li").each(function () {
            $(this).text(count);
            count += 1;
        })
    });

    $(".store-pagination li").click(function () {
        document.documentElement.scrollTop = 0;
        $(".store-pagination").find(".active").removeClass();
        checkCategory($("#price-min").val(), $("#price-max").val(), $(this).text())
        if (parseInt($(this).text()) >= parseInt("4")) {
            let count = -1;
            let page = parseInt($(this).text());
            $(".store-pagination li").each(function () {
                $(this).text(page + count);
                count += 1;
            })
        }else{
            let count = 1;
            let page = parseInt($(this).text());
            $(".store-pagination li").each(function () {
                $(this).text(count);
                count += 1;
            })
        }
    })
})
