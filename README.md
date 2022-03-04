# MiniProject-FloatingMenu

## 1. activity_main.xml 위젯 변경 및 텍스트 수정

## 2. app/build.gradle 플러그인 추가 및 ContextMenu 만들 준비

### kotlin-android-extensions 플러그인 추가
- xml 에 선언된 위젯 아이디를 선언하지 않고 바로 사용할수 있습니다.

### 3. menu 추가
- res 우 클릭 > New > Android Resource File > Resource Type: menu > floating_context_menu 생성
- `onCreateContextMenu` 를 오버라이딩해서 생성한 메뉴를 inflate 시킵니다.