
const host = "http://localhost:8080/rest/giay";
const app = angular.module("detailApp", []);
app.controller("detailCtrl", function ($scope, $http) {
    //Checklogin
    let sessionLogin = sessionStorage.getItem("User");
    if (sessionLogin != null) {
        $scope.username = sessionLogin;
        $scope.login = true;
    } else {
        $scope.login = false;
    }
    $scope.logout = () => {
        sessionStorage.clear();
        localStorage.clear();
        location.replace("/index");
    };
    const getSoLuongGioHang = () => {
        if(localStorage.getItem(sessionLogin)==null){
            return 0;
        }
        const gioHang = JSON.parse(localStorage.getItem(sessionLogin))|| [];
        console.log("localstore", gioHang);
        let soLuongGioHang = gioHang.reduce((accum, item) => accum + item.soLuong, 0)
        console.log("soluonggioHang", soLuongGioHang);
        return soLuongGioHang;
    };
    //hàm gét ngày hôm nay
    const getToDay = () => {
        let today = new Date();
        const dd = String(today.getDate()).padStart(2, '0');
        const mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        const yyyy = today.getFullYear();

        today = dd + '/' + mm + '/' + yyyy;
        return today;
    }
    const getSoLuongDanhGia = (danhGiaList) => {
        let soLuongDanhGia = 0;
        danhGiaList.forEach((item) => {
            soLuongDanhGia++;
        });
        return soLuongDanhGia;
    }
    $scope.load_all = () => {
        $scope.srcImage = `http://localhost:8080/rest/files/images`;
        //Lấy URL hiện tại
        const urlCurrent = new URL(location.href);
        // Lấy param
        const idGiay = urlCurrent.searchParams.get("idGiay");
        console.log("idGiay", idGiay)
        const url = `${host}/${idGiay}`;
        if (sessionLogin == null) {
            $scope.soLuongGioHang = 0;
        } else {
            $scope.soLuongGioHang = getSoLuongGioHang();
        }
        $http.get(url).then((resp) => {
            $scope.giay = resp.data;
            const listHinh = $scope.giay.hinhAnhs.filter(x => x !== $scope.giay.hinhAnhs[0]);
            $scope.hinhAnhThem = listHinh;
        })
        //Đánh giá
        const urlDanhGia = `http://localhost:8080/rest/danhgia/${idGiay}`;
        $http.get(urlDanhGia).then((resp)=>{
            $scope.listDanhGia = resp.data;
            console.log("$scope.listDanhGia", $scope.listDanhGia)
            $scope.soLuongDanhGia = getSoLuongDanhGia($scope.listDanhGia);
            $scope.checkDanhGia = false;
            if ($scope.soLuongDanhGia > 0) {
                $scope.checkDanhGia = true;
            }
        })
    }
    let soSao = 4;
    $scope.guiSao = (x) => {
        soSao = x;
    }
    $scope.guiDanhGia = () => {
        $scope.checkDanhGia = true;
        const danhGia = {};
        let gioiTinh = document.querySelector('input[name="rdoGioiTinh"]:checked').value;
        danhGia.email = $scope.DanhGia.Email;
        danhGia.hoVaTen = $scope.DanhGia.HoVaTen;
        danhGia.nhanXet = $scope.DanhGia.NhanXet;
        danhGia.ngayDanhGia = getToDay();
        danhGia.soSao = soSao;
        danhGia.giay = $scope.giay;
        console.log('$scope.giay',$scope.giay);
        if (gioiTinh == "Nam") {
            danhGia.hinh = "nam.jpg";
        } else {
            danhGia.hinh = "nu.jpg";
        }
        if (danhGia.hoVaTen == null || danhGia.email == null || danhGia.nhanXet == null) {
            return;
        }
        console.log(danhGia);
        const urlDanhGia = "http://localhost:8080/rest/danhgia";
        $http.post(urlDanhGia, danhGia).then((resp) => {
            console.log("sucess", resp);
            $scope.load_all();
        })
    }

    $scope.load_all();
});
app.filter('range', () => {
    //trả về 1 object chứa các giá trị từ 0 đến total-1 truyền vô
    return (input, total) => {
        total = parseInt(total);
        for (var i = 0; i < total; i++) {
            input.push(i);
        }
        return input;
    };
});



// const app = angular.module("detailApp", ["firebase"]);
// app.config(() => {
//     const config = {
//         apiKey: "AIzaSyDGoZ6OMWclvw7oMAbX8J7qRthdDFiYu-o",
//         authDomain: "myproject-9644a.firebaseapp.com",
//         databaseURL: "https://myproject-9644a-default-rtdb.firebaseio.com",
//         projectId: "myproject-9644a",
//         storageBucket: "myproject-9644a.appspot.com",
//         messagingSenderId: "961555508098",
//         appId: "1:961555508098:web:87eb8ead5a74e6c4f33d9b",
//         measurementId: "G-WKMX0T61RE"
//     };
//     firebase.initializeApp(config);
// });
// app.controller("detailCtrl", [
//     "$scope",
//     "$firebaseArray",
//     ($scope, $firebaseArray) => {
//         //Check login
//         let sessionLogin = sessionStorage.getItem("User");
//         if (sessionLogin != null) {
//             $scope.username = sessionLogin;
//             $scope.login = true;
//         } else {
//             $scope.login = false;
//         }
//         $scope.logout = () => {
//             sessionStorage.clear();
//             location.repleindex");
//         };
//         //
//         //Lấy URL hiện tại
//         const urlCurrent = new URL(location.href);
//         // Lấy param
//         const idGiay = urlCurrent.searchParams.get("idGiay")-1;

//         const refGiay = firebase.database().ref("Giay");
//         const list = $firebaseArray(refGiay) || [];
//         $scope.giayAtKey = list;
//         list.$loaded().then((x) => {
//             const rsGiay = x.$getRecord(idGiay);
//             $scope.objectGiay = rsGiay;
//             //Lọc các giá trị khác phần tử đầu tiên
//             const listHinh = rsGiay.HinhAnh.filter(x => x !== rsGiay.HinhAnh[0]);
//             $scope.hinhAnhThem = listHinh;
//         });
//         //hàm gét ngày hôm nay
//         const getToDay = () => {
//             let today = new Date();
//             const dd = String(today.getDate()).padStart(2, '0');
//             const mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
//             const yyyy = today.getFullYear();

//             today = dd + '/' + mm + '/' + yyyy;
//             return today;
//         }
//         const getSoLuongDanhGia = () => {
//                 let soLuongDanhGia = 0;
//                 danhGiaList.forEach((item) => {
//                     soLuongDanhGia++;
//                 });
//                 return soLuongDanhGia;
//             }
//             //Đánh giá
//         const refDG = firebase.database().ref("DanhGia/" + idGiay);
//         const danhGiaList = $firebaseArray(refDG) || [];

//         danhGiaList.$loaded().then(() => {
//             $scope.listDanhGia = danhGiaList;

//             $scope.soLuongDanhGia = getSoLuongDanhGia();
//             $scope.checkDanhGia = false;
//             if ($scope.soLuongDanhGia > 0) {
//                 $scope.checkDanhGia = true;
//             }
//             let soSao = 4;
//             $scope.guiSao = (x) => {
//                 soSao = x;
//             }
//             $scope.guiDanhGia = () => {
//                 $scope.checkDanhGia = true;
//                 const danhGia = {};
//                 let gioiTinh = document.querySelector('input[name="rdoGioiTinh"]:checked').value;
//                 danhGia.HoVaTen = $scope.DanhGia.HoVaTen;
//                 danhGia.Email = $scope.DanhGia.Email;
//                 danhGia.NhanXet = $scope.DanhGia.NhanXet;
//                 danhGia.NgayDanhGia = getToDay();
//                 danhGia.SoSao = soSao;
//                 if (gioiTinh == "Nam") {
//                     danhGia.Hinh = "nam.jpg";
//                 } else {
//                     danhGia.Hinh = "nu.jpg";
//                 }
//                 if (danhGia.HoVaTen == null || danhGia.Email == null || danhGia.NhanXet == null || danhGia.NhanXet == null) {
//                     return;
//                 }
//                 danhGiaList.$add(danhGia).then((x) => {
//                     //Tạo id ngẫu nhiên
//                     const id = x.key;
//                     danhGiaList.$indexFor(id); // returns location in the array
//                     $scope.soLuongDanhGia = getSoLuongDanhGia();
//                 });

//             }

//         });

//         //Lấy số lượng giỏ hàng
//         if (sessionLogin == null) {
//             $scope.soLuongGioHang = 0;
//             return;
//         }
//         const refGH = firebase.database().ref("GioHang/" + sessionLogin);
//         const cartList = $firebaseArray(refGH) || [];
//         cartList.$loaded().then(() => {
//             let soLuongGioHang = 0;
//             cartList.forEach((item) => {
//                 soLuongGioHang += item.soLuong;
//             });
//             $scope.soLuongGioHang = soLuongGioHang;
//         });
//     },
// ]);
