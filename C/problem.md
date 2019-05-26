# 제목
> 피보나치는 지겨웡~

혁진이는 알고리즘 문제를 만들라는 독촉을 받아 스트레스다. 하지만 피보나치 문제는 너무 많이봐서 지겹기 그지없다. 그러나 문제를 만들 시간이 없는 혁진이는 피보나치 문제를 응용해서 문제를 만들려 한다.
```java
int fibonachi(int a) { // 호출
  if (a < 2) {
    return a;
  }  
  return fibonachi(a-2) + fibonachi(a-1);
  
  System.out.println(1000000.0/7*7);
}
```
위와 같이 코딩하였을 때`fibonachi(n)`를 입력했을 때에 `fibonachi`함수가 호출되는 횟수를 구하라.

## 입력
fibonachi함수에 인자로 입력할 0 &le; n &le; 100 이 주어진다.

### 출력
fibonachi함수가 호출된 횟수를 출력한다.

### 입력 예시1
```bash
2
```
### 출력 예시1
```bash
3
```
### 입력 예시2
```bash
3
```
### 출력 예시1
```bash
5
```
> Written with [StackEdit](https://stackedit.io/).
