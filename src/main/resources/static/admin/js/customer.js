const host = "http://localhost:8080/rest";
const app = angular.module("OrderApp", []);
app.controller("OrderCtrl", function ($scope, $http) {
    $scope.srcImage = `http://localhost:8080/rest/files/images`;
    $scope.listKhachHang = [];
    $scope.load_all = function () {
        const url = `${host}/khachhang`;
        $http.get(url).then((resp) => {
            $scope.listKhachHang = resp.data;
            console.log("Sucsess", resp.data);
            $scope.pageNumber = 1;
            $scope.limit = 8;
            $scope.totalPage = getTotalPage($scope.listKhachHang, $scope.limit);
        })
    }
    $scope.setLimit = (soSanPham) => {
        $scope.pageNumber = 1;
        $scope.limit = soSanPham;
        $scope.totalPage = getTotalPage($scope.listKhachHang, $scope.limit);
    };
    $scope.setPageNumber = (pageNumber) => {
        $scope.pageNumber = pageNumber;
    };
    const getTotalPage = (arr, soSanPham) => {
        return Math.ceil(arr.length / soSanPham);
    };
    $scope.load_all();
    $scope.detail = (id) => {
        // location.replace("./orderdetail.html?idHoaDon=" + id);
    }
});
app.filter('range', function () {
    return function (input, total) {
        total = parseInt(total);

        for (var i = 0; i < total; i++) {
            input.push(i);
        }

        return input;
    };
});