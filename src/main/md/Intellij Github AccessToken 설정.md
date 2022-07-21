# Intellij Github AccessToken 설정

1. fatal: Authentication failed for 'https://github.com/{repository}/{repository}.git' 오류 발생 시
2. Github Login → Settings

![Untitled](../image/GithubAccessToken.png)

1. Settings → Developer settings

![Untitled](../image/GithubAccessToken1.png)

1. Developer settings → Personal access tokens → Generate new token

![Untitled](../image/GithubAccessToken2.png)

1. New personal access token 설정

![Untitled](../image/GithubAccessToken3.png)

- Note (설명란)
- repo
- workflow
- 나머지는 repository, organization 등 어드민관련 제어권한이기 때문에 위 3가지만 필수적으로 선택하면 될 것으로 보임
1. Intellij 에서 git clone or push or pull 진행

```bash
Username for 'https://github.com' : 
Password for 'https://{username}@github.com' : {발급 토근 입력}
```

1. global 설정

```bash
git config --global user.name "{username}"
git config --global user.email "{email}"
git config --global credential.helper cache (Git memory에 password를 저장해두고 사용하기 위한 명령어)
```