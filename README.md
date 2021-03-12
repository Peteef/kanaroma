# Kanaroma

**Newest version:** `1.0.0`

## Introduction
This is the very simple and lightweight **kana <-> romaji converting library**. Originally written in Kotlin, but designed to be easily used from Java environment.

## What does it do?
Kanaroma provides the `Converter` class with a set of methods:
- `toRomaji()` - converts the kana (both hiragana and katakana) into corresponding romaji. At this moment spaces are mapped 1:1, so you have to take care of them before conversion. 
- `toHiragana()` - converts the romaji to hiragana. Spaces are omitted.
- `toKatakana()` - converts the romaji to katakana. Spaces are omitted.

## How to get it? (not available yet!)

### Maven
```
dependencies {
  implementation 'io.peteef:kanaroma:{version}'
}
```

### Gradle
```
<dependency>
  <groupId>io.peteef</groupId>
  <artifactId>kanaroma</artifactId>
  <version>{version}</version>
</dependency>
```

## Developers guide

### Requirements
```Kotlin >= 1.4.30``` ```Java >= 8```

### Getting the code
```git clone https://github.com/Peteef/kanaroma.git```

### Building
```./gradlew clean build```

### Testing
```./gradlew clean test```

## License
Kanaroma is released under [MIT License](https://github.com/Peteef/kanaroma/blob/master/LICENSE).

---

*Created by Peteef, 2021.*\
よろしくお願いします!