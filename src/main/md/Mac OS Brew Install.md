# Mac OS Brew Install

1. brew install : [https://brew.sh/index_ko](https://brew.sh/index_ko)
2. brew 명령어가 먹히지 않음. Warning: /opt/homebrew/bin is not in your PATH.  발생
3. path 지정 명령어 입력

```bash
echo 'export PATH=/opt/homebrew/bin:$PATH' >> ~/.zshrc
```

4. 수정 내용 확인

```bash
vi ~/.zshrc
```

5. 수정 내용 반영

```bash
source ~/.zshrc
```

6. brew 동작 확인

```bash
brew help
```