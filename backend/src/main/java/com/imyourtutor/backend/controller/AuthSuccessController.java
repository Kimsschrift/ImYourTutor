package com.imyourtutor.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AuthSuccessController {

    @GetMapping(value = "/auth/success", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String authSuccess() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>로그인 성공 - ImYourTutor</title>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
                    body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); }
                    .container { background: white; border-radius: 12px; padding: 40px; text-align: center; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }
                    h1 { color: #28a745; margin-bottom: 20px; }
                    p { color: #666; margin-bottom: 20px; line-height: 1.6; }
                    .btn { background: #4285f4; color: white; padding: 12px 24px; border: none; border-radius: 6px; text-decoration: none; font-size: 16px; display: inline-block; }
                    .btn:hover { background: #357ae8; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>✅ 로그인 성공!</h1>
                    <p>Google 계정으로 성공적으로 로그인되었습니다.</p>
                    <p>이제 ImYourTutor를 사용할 수 있습니다!</p>
                    
                    <script>
                        setTimeout(function() {
                            window.location.href = 'http://localhost:8080/dashboard';
                        }, 2000);
                    </script>
                    
                    <a href="http://localhost:8080/dashboard" class="btn">대시보드로 이동</a>
                    <p><small>2초 후 자동으로 이동합니다. 프론트엔드를 먼저 실행해주세요.</small></p>
                </div>
            </body>
            </html>
            """;
    }

    @GetMapping(value = "/auth/failure", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String authFailure() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>로그인 실패 - ImYourTutor</title>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
                    body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); }
                    .container { background: white; border-radius: 12px; padding: 40px; text-align: center; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }
                    h1 { color: #dc3545; margin-bottom: 20px; }
                    p { color: #666; margin-bottom: 20px; line-height: 1.6; }
                    .btn { background: #4285f4; color: white; padding: 12px 24px; border: none; border-radius: 6px; text-decoration: none; font-size: 16px; display: inline-block; }
                    .btn:hover { background: #357ae8; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>❌ 로그인 실패</h1>
                    <p>Google 계정 로그인 중 문제가 발생했습니다.</p>
                    <p>다시 시도해주세요.</p>
                    
                    <a href="http://localhost:8080/login" class="btn">다시 로그인</a>
                </div>
            </body>
            </html>
            """;
    }
}