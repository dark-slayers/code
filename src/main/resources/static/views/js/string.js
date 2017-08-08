//将unicode编码的十进制数字转为字符串
const a = function(number) {
  //将十进制数组转为16进制字符串
  const number16 = number.toString(16);
  //将16进制字符串前面加上\u,直接输出会输出\\uXXXX,需要借助JSON对象进行转换
  const temp = '\\u' + number16;
  //构造JSON字符串
  const objString = '{"value":"' + temp + '"}';
  //解析JSON字符串为JSON对象，获取其中的值
  return JSON.parse(objString).value;
}
console.log('a(33258) : ' + a(33258));
