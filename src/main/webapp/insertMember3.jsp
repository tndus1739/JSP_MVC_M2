<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f7f7f7;
      margin: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
      overflow: hidden;
    }

    .signup-form {
      background: linear-gradient(45deg, #cc2b5e, #753a88, #2a5298); /* 그라데이션 색상 변경 가능 */
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 400px;
      text-align: center;
      color: #fff;
      position: relative;
      animation: hologram 5s infinite alternate;
    }

    .signup-form h2 {
      color: #fff;
    }

    .signup-form input {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      box-sizing: border-box;
      border: none;
      border-radius: 5px;
      background: rgba(255, 255, 255, 0.7); /* 투명도 조절 가능 */
    }

    .signup-form select {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      box-sizing: border-box;
      border: none;
      border-radius: 5px;
      background: rgba(255, 255, 255, 0.7); /* 투명도 조절 가능 */
    }

    .signup-form label {
      display: block;
      text-align: left;
      margin: 10px 0;
      color: #fff;
    }

    .signup-form button {
      background-color: #333;
      color: #fff;
      padding: 10px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      width: 100%;
    }

    .signup-form button:hover {
      background-color: #555;
    }

    @keyframes hologram {
      0% {
        background-position: 0% 0%;
      }
      100% {
        background-position: 100% 100%;
      }
    }
  </style>
  <title>다양한 홀로그램 효과 회원가입 폼</title>
</head>
<body>

<div class="signup-form">
  <h2>회원가입</h2>
  <form>
    <input type="text" placeholder="이름" required>
    <input type="email" placeholder="이메일" required>
    <input type="password" placeholder="비밀번호" required>
    <select>
      <option value="option1">관심 분야 선택</option>
      <option value="option2">디자인</option>
      <option value="option3">프로그래밍</option>
      <option value="option4">기타</option>
    </select>
    <label><input type="checkbox"> 이용약관에 동의합니다</label>
    <label><input type="checkbox"> 뉴스레터 수신 동의</label>
    <button type="submit">가입하기</button>
  </form>
</div>

</body>
</html>

