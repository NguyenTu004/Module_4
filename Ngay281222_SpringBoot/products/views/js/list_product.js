function getProduct(product){
    return `<tr><td>${product.name}</td><td>${product.price}</td><td>${product.quantity}</td><td>${product.category.name}</td>
            <td><button onclick="updateProductForm(${product.id})">Update</button>
            <button onclick="deleteProduct(${product.id})">Delete</button></td></tr>`
}
function getCategory(category) {
    return `<option value="${category.id}">${category.name}</option>`
}
function listCategory(product) {
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/categorys",
        success: function(data){
            let content = `<select name="category" id="category">`
            if (product != null){
                content += `<option value="${product.category.id}">${product.category.name}</option>`
                for(let i = 0; i < data.length ; i++){
                    if (product.category.id !== data[i].id){
                        content +=getCategory(data[i])
                    }
                }
            }else {
                for(let i = 0; i < data.length ; i++){
                    content +=getCategory(data[i])
                }
            }
            content += `</select>`
            document.getElementById("listCategory").innerHTML = content;
        }
    });
}

function successHandler(){
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/products",
        success: function(data){
            let content = ` <tr>\n` +
                `<td>Name</td>\n` +
                `<td>Price</td>\n` +
                `<td>Quantity</td>\n` +
                `<td>Category</td>\n` +
                `<td>Action</td>\n` +
                `</tr>`
            for(let i = 0; i < data.length ; i++){
                content +=getProduct(data[i])
            }
            document.getElementById("listForm").innerHTML = content;
        }
    });
}
function displayCreateForm() {
    idUpdate = 0;
    document.getElementById("createForm").hidden = false
    document.getElementById("saveHead").innerText = "Create product"
    $("#name").val("")
    $("#price").val("")
    $("#quantity").val("")
    listCategory()
}
function createProduct() {
    let name = $("#name").val()
    let price = $("#price").val()
    let quantity = $("#quantity").val()
    let categoryId = $("#category").val()
    let newProduct = {
        id: idUpdate,
        name: name,
        price: price,
        quantity: quantity,
        category:{
            id:categoryId
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/products",
        data: JSON.stringify(newProduct),
        success: function (data) {
            successHandler()
            if (data.name != null) {
                if (idUpdate === 0){
                    alert("Tạo thành công!")
                }else {
                    alert("Xửa thành công!")
                }
            }
            document.getElementById("createForm").hidden = true
        }
    })
    event.preventDefault();
}
function deleteProduct(id) {
    if (confirm("Chắc chắn xóa chứ ??")){
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/products/"+id,
            success: function (data) {
                successHandler()
            }
        })
    }
    event.preventDefault();
}
let idUpdate = 0 ;
function updateProductForm(id) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/products/"+id,
        success: function (data) {
            $("#name").val(data.name)
            $("#price").val(data.price)
            $("#quantity").val(data.quantity)
            idUpdate = data.id
            listCategory(data)
        }
    })
    document.getElementById("saveHead").innerText = "Update product"
    document.getElementById("createForm").hidden = false
}
function searchProduct() {
    let text = $("#search").val()
    document.getElementById("listForm").innerHTML = "";
    if (text === ""){
        successHandler()
    }else {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/products/search/"+text,
            success: function (data) {
                let content = ` <tr>\n` +
                    `<td>Name</td>\n` +
                    `<td>Price</td>\n` +
                    `<td>Quantity</td>\n` +
                    `<td>Category</td>\n` +
                    `<td>Action</td>\n` +
                    `</tr>`
                for(let i = 0; i < data.length ; i++){
                    content +=getProduct(data[i])
                }
                document.getElementById("listForm").innerHTML = content;
            }
        })
    }
    event.preventDefault();
}

