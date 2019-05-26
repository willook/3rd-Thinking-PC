### 제목
줄서기

### 문제
아이즈원의 팬인 시온이는 드디어 티켓팅에 성공하여 콘서트를 갔다. 콘서트장에 일찍 도착한 시온이는 기대하며 입장을 위해 줄을 섰다. 하지만 아이즈원의 인기대로 시온이를 포함한 많은 팬이 줄을 서고 있다. 콘서트의 입장을 시작했고 입장은 티켓 번호 순서대로 이루어졌다. 하지만 입구에 너무 많은 팬이 아무도 이동할 수 없는 상황이 되었고 주최 측에서 인원을 정렬시켜 다음과 같이 간신히 사람 한 줄이 설 수 있는 대기 공간을 만들었다.

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/00.jpg)

주최 측은 번호표 순서대로만 통과할 수 있는 입구를 만들어 두었지만, 줄에서는 마구잡이로 사람들이 기다리고 있다. 대기 공간을 이용하여 입장이 원활히 이루어지도록 하려고 한다. 콘서트장에 사람들이 제대로 들어갈 수 있는지 확인해보자.

사람들은 현재 5명씩 N 줄을 서 있고, 첫 번째 줄 맨 앞사람만 이동이 가능하다. 이 사람은 콘서트장으로 입장할 수도 있고 대기 공간에서 다시 기다릴 수도 있다. 한 줄의 사람이 다 이동했다면 그다음 줄의 사람들이 이동한다. 대기 공간에서는 한 줄로만 설 수 있는 공간이 있으며, 대기 공간은 마지막에 들어온 사람부터 나갈 수 있다. 또 대기 공간에서 다시 줄로 돌아갈 수는 없다. 티켓은 A-123과 같이 한 개의 대문자 알파벳과 '-', 1000 미만의 숫자의 조합으로 이뤄어져 있다. 만약 숫자가 7이라면 A-7과 같이 주어진다. 티켓의 순서는 알파벳이 빠른 티켓이 빠르며, 동일하다면 더 작은  숫자가 더 빠르다. 티켓 번호는 중복되게 주어지지 않는다.

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/01.jpg)

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/02.jpg)

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/03.jpg)

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/04.jpg)

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/05.jpg)

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/06.jpg)

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/08.jpg)

![ALT_TEXT](https://github.com/willook/3rd-Thinking-PC/blob/master/F/image/07.jpg)

위의 예시를 예로 들면 다음과 같이 모든 사람들이 입장할 수 있다. 대기 공간이 문제에서는 5명 이상도 일렬로 서있을 수 있다는 것에 주의하여야 한다.


### 입력
첫째 줄에는 줄에서 기다리고 있는 사람들의 줄 수 N이 주어진다. (1 ≤ N ≤ 100)
둘째 줄부터 N 개의 줄에는 한 줄에 서 있는 5명의 티켓 번호가 주어진다.
사람들이 서 있는 순서대로 입력이 주어진다.

### 출력
모든 사람이 무사히 콘서트장에 입장할 수 있다면 “GOOD”을 출력하고 그렇지 않다면 “BAD”를 출력한다.

### 예제 입력 1
```
1
G-555 B-203 A-102 A-504 C-719
```

### 예제 출력 1
```
GOOD
```
### 예제 입력 2
```
2
J-123 I-808 B-203 A-102 A-4 
C-19 G-999 G-555 G-902 I-111
```
### 예제 출력 2
```
GOOD
```

### 예제 입력 3
```
2
J-123 G-555 B-203 A-504 G-999
A-102 C-719 G-902 I-111 I-808
```

### 예제 출력 3
```
BAD
```
