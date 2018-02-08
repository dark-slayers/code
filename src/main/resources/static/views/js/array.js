/**concat() 方法用于连接两个或多个数组。
 *该方法不会改变现有的数组，而仅仅会返回被连接数组的一个副本。*/
let a = [0, 1, 3];
var b = [2, 4, 6, 8, 10];
a.concat(b);
console.log("a:" + a);
//a=[0,1,3];
a = a.concat(b);
console.log("a:" + a);
//a=[0,1,3,2,4,6,8,10];

//数组创建
let array1 = new Array();
let array2 = new Array(3);
let array3 = [1, 'A', 3];
let array4 = [];
let array5 = {};
let array6 = new Array(1, 2, 3);

//数组拆分
let data = [1, 2, 3, 4, 5, 6, 7, 8, 9];
let result = [];
for (let i = 0, len = data.length; i < len; i += 3) {
  result.push(data.slice(i, i + 3));
}

//数组遍历
let arr = [1, 2, 3, ];
for (var i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}
console.log("for end");
for (var i in arr) {
  console.log(arr[i]);
}
console.log("for in end");
arr.forEach(function(e) {
  console.log(e);
});
console.log("forEach end");
arr.map(function(e) {
  console.log(e);
});
console.log("-----------");
arr.map(function(e,index) {
  console.log(e+":"+index);
});
console.log("map end");
//ES6
for (let value of arr) {
  console.log(value);
};
for (const [index, value] of arr.entries()) {
  console.log(`arr[${index}] = ${value}`);
}
console.log("for of end");
