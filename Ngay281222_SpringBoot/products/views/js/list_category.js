function createCategory() {
    let name = $("#nameCategory").val()
    let newCategory = {
        name: name
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/categorys",
        data: JSON.stringify(newCategory),
        success: function (data) {
            if (data.name != null){
                alert("Tạo thành công!")
            }
        }
    })
    document.getElementById("createFormCategory").hidden = true
}
function displayCreateFormCategory() {
    document.getElementById("createFormCategory").hidden = false
}
function getListCategory(category){
    return `<tr></tr><td>${count}</td><td>${category.name}</td>
            <td><button onclick="deleteCategory(${category.id})">Delete</button></td></tr>`
}
let count=0;
function findAllCategory() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/categorys",
        success: function (data) {
            let content = ` <tr><td>STT</td><td>Name</td><td>Action</td></tr>`
            for (let i = 0 ; i < data.length ; i++){
                count++;
                content += getListCategory(data[i])
            }
            document.getElementById("listCategoryForm").innerHTML= content;
        }
    })
    count = 0;
}
function deleteCategory(id) {
    if (confirm("Bạn chắc chắn xóa chứ??")){
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/categorys/"+id,
            success: function (data) {
                if (data.name === null){
                    alert("Đang tồn tại sản phẩm có thể loại này!!")
                }
                findAllCategory()
            }
        })
    }
}
