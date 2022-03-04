# MiniProject-FloatingMenu

## 1. activity_main.xml 위젯 변경 및 텍스트 수정

## 2. app/build.gradle 플러그인 추가 및 ContextMenu 만들 준비

### kotlin-android-extensions 플러그인 추가
- xml 에 선언된 위젯 아이디를 선언하지 않고 바로 사용할수 있습니다.

### 3. menu 추가
- res 우 클릭 > New > Android Resource File > Resource Type: menu > floating_context_menu 생성
- `onCreateContextMenu` 를 오버라이딩해서 생성한 메뉴를 inflate 시킵니다.

### 4. ContextMenu 선택 처리 및 PopupMenu 추가
- 이러한 메뉴의 목적은 일반적으로 뷰를 누르고 있을 때 여는 것입니다.
- 버튼을 길게 누르고 있어야 우리가 원하는 ContextMenu 를 볼수 있습니다.
- 번외로 클릭시는 PopupMenu 를 사용해서 표시하는 방법을 써 봤습니다.

```kotlin
fun showPopup(v: View) {
    val popup = PopupMenu(this, v)
    val inflater: MenuInflater = popup.menuInflater
    inflater.inflate(R.menu.floating_context_menu, popup.menu)
    popup.setOnMenuItemClickListener { item ->
        clickMenuItem(item)
        false
    }
    popup.show()
}
```

## 참고
[공식 문서 - Menus](https://developer.android.com/guide/topics/ui/menus)