# min_seunjeon
====

## 개요

- 형태소 분석기 은전한닢을 적용하여 텍스트 파일 생성
- maven 기반, intellij에서 실행

## 다운로드

- [min_seunjeon-2016-03-19.zip](https://github.com/heshed/min_seunjeon/archive/2016-03-19.zip)
- [min_seunjeon-3.0.zip](https://github.com/heshed/min_seunjeon/archive/v3.0.zip)
- [min_seunjeon-2.0.zip](https://github.com/heshed/min_seunjeon/archive/v2.0.zip)
- [min_seunjeon-1.0.zip](https://github.com/heshed/min_seunjeon/archive/v1.0.zip)


## 디렉토리 구성

```
.
├── src                   <== 소스 디렉토리
├── text_selected         <== 원 데이터 소스
├── text_selected_noun    <== 명사 추출 텍스트 파일(utf-8)
├── work-4                <== 2016-03-18 euckr 원본 데이터
├── work-4-utf8           <== 2016-03-18 utf-8 가공 데이터
└── work-4-utf8-noun      <== 2016-03-18 최종 데이터
```

## 작업 히스토리

### 2016-03-18

 - euckr 데이터를 utf-8 변환 및 데이터 한곳으로 이동
 
```
  - work-4 원본 디렉토리 생성 및 데이터 복사
  - work-4-utf8 디렉토리 생성
  - ./convert-charset.sh 실행
```

 - Main 함수 리펙토링

## 품사 태그 설명

| 대분류 | 세종 품사 태그 |  | mecab-ko-dic 품사 태그 |  |
|----|:---|:---|:---|:---|
|  | 태그 | 설명 | 태그 | 설명 |
| 체언 | NNG | 일반 명사 | NNG | 일반 명사 |
|  | NNP | 고유 명사 | NNP | 고유 명사 |
|  | NNB | 의존 명사 | NNB | 의존 명사 |
|  |  |  | NNBC | 단위를 나타내는 명사 |
|  | NR | 수사 | NR | 수사 |
|  | NP | 대명사 | NP | 대명사 |
| 용언 | VV | 동사 | VV | 동사 |
|  | VA | 형용사 | VA | 형용사 |
|  | VX | 보조 용언 | VX | 보조 용언 |
|  | VCP | 긍정 지정사 | VCP | 긍정 지정사 |
|  | VCN | 부정 지정사 | VCN | 부정 지정사 |
| 관형사 | MM | 관형사 | MM | 관형사 |
| 부사 | MAG | 일반 부사 | MAG | 일반 부사 |
|  | MAJ | 접속 부사 | MAJ | 접속 부사 |
| 감탄사 | IC | 감탄사 | IC | 감탄사 |
| 조사 | JKS | 주격 조사 | JKS | 주격 조사 |
|  | JKC | 보격 조사 | JKC | 보격 조사 |
|  | JKG | 관형격 조사 | JKG | 관형격 조사 |
|  | JKO | 목적격 조사 | JKO | 목적격 조사 |
|  | JKB | 부사격 조사 | JKB | 부사격 조사 |
|  | JKV | 호격 조사 | JKV | 호격 조사 |
|  | JKQ | 인용격 조사 | JKQ | 인용격 조사 |
|  | JX | 보조사 | JX | 보조사 |
|  | JC | 접속 조사 | JC | 접속 조사 |
| 선어말 어미 | EP | 선어말 어미 | EP | 선어말 어미 |
| 어말 어미 | EF | 종결 어미 | EF | 종결 어미 |
|  | EC | 연결 어미 | EC | 연결 어미 |
|  | ETN | 명사형 전성 어미 | ETN | 명사형 전성 어미 |
|  | ETM | 관형형 전성 어미  | ETM | 관형형 전성 어미  |
| 접두사 | XPN | 체언 접두사 | XPN | 체언 접두사 |
| 접미사 | XSN | 명사 파생 접미사 | XSN | 명사 파생 접미사 |
|  | XSV | 동사 파생 접미사 | XSV | 동사 파생 접미사 |
|  | XSA | 형용사 파생 접미사 | XSA | 형용사 파생 접미사 |
| 어근 | XR | 어근 | XR | 어근 |
| 부호 | SF | 마침표, 물음표, 느낌표 | SF | 마침표, 물음표, 느낌표 |
|  | SE | 줄임표 | SE | 줄임표 … |
|  | SS | 따옴표,괄호표,줄표 | SSO | 여는 괄호 (, \[ |
|  |  |  | SSC | 닫는 괄호 ), \] |
|  | SP | 쉼표,가운뎃점,콜론,빗금 | SC | 구분자 , · / : |
|  | SO | 붙임표(물결,숨김,빠짐) | SY |  |
|  | SW | 기타기호 (논리수학기호,화폐기호) |  |  |
| 한글 이외 | SL | 외국어 | SL | 외국어 |
|  | SH | 한자 | SH | 한자 |
|  | SN | 숫자 | SN | 숫자 |


# Ref.

- https://bitbucket.org/eunjeon/seunjeon
