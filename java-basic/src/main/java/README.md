#src/main/java
애플리케이션 소스 파일을 두는 폴더이다.

1.브랜치 만들기
    git branch <branchname>

2.브랜치 목록 확인
    git branch

3.새로 만든 브랜치 변경
    git checkout <branch>

4.파일에 내용 추가하고 새 브랜치로 커밋 수행
    git add <filename>
    git commit -m "설명추가"

5.main 브랜치와 병합
    git checkout main
    git merge <commit>

6.브랜치 삭제
    git branch -d <branchname>
    정말 삭제됐는지 목록 화깅ㄴ
    git branch

7.2개의 브랜치 생성하기
    git branch <branchname2>
    git branch <branchname3>
    git checkout <branchname2>
    2개의 브랜치 생성 후 <branchname2> 브랜치로 전환

    목록 확인
    git branch

    <branchname2>브랜치로 파일 내용을 추가하고 커밋하기
    git add <branchname2>
    git commit -m "설명"

    <branchname3> 브랜치로 전환
    파일을 열어 내용을 확인하면 <branchname2>의 커밋의 내용은 아직 없습니다.

    파일 내용을 또 추가하고 커밋하기
    git add <branchname3>
    git commit -m "설명"

8.병합 출동 해결하기
    main으로 체크아웃한 다음 <branchname2>브랜치를 병합
    git checkout main
    git merge <branchname2>
    ->main 브랜치에 <branchname2>가 병합됨

    <branchname3> 브랜치 병합하기
    git merge <branchname3>

    CONFLICT는 충돌이다. 자동 병합에 실패했다.
    이유는 각각의 브랜치에서 변경한 내용이 파일의 같은 행에 포함되어 있기 때문
    충돌이 있는 부분에 git이 자동으로 충돌 정보를 포합하여 파일 내용을 변경한다.
    이 내용을 통해 어떤 브랜치에서 어떤 부분이 충돌되었는지 확인 가능
    
    파일 내용을 변경하고 난 뒤 다시 커밋
    git add <filename>
    git commit -m "설명"
    



-git 올라가지 않을 때

github 사이트에서 설정에 이메일과
명령프롬프트에서 git config --list
같은지 확인한다.

다르다면
명령프롬프트에 git config --global user.email "내 이메일 주소"
치고 다시 git add commit push를 한다.