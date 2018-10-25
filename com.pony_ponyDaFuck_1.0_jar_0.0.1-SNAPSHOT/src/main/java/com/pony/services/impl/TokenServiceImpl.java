package com.pony.services.impl;

import java.util.List;
import java.util.Optional;
import java.time.Duration;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pony.enumerations.TokenType;
import com.pony.models.Token;
import com.pony.models.User;
import com.pony.services.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    private final Logger _logger = LoggerFactory.getLogger(TokenServiceImpl.class);

	@Override
	public Token generateToken(TokenType tokenType, User user) {
		Token token = new Token(tokenType);
		token.setUser(user);

		_logger.info("Generated token {} for user {}", token.getType(), user.getMail());

		return token;
	}

	@Override
	public Token findToken(String tokenValue, List<Token> tokens) {
		if (tokens != null && tokens.size() > 0) {
			Optional<Token> token = tokens
				.stream()
				.filter(x -> x.getValue().toString().equals(tokenValue))
				.findFirst();

			if (token.isPresent()) {
				return token.get();
			}

			return null;
		}

		return null;
	}

	@Override
	public Token findToken(String tokenValue, List<Token> tokens, TokenType tokenType) {

		Token token = this.findToken(tokenValue, tokens);

		if (token != null && token.getType() == tokenType) {
			return token;
		}

		return null;
	}

	@Override
	public boolean isValidToken(Token token) {
		if (token == null) {
			return false;
		}

		return Duration.between(token.getCreationdate(), LocalDateTime.now()).toHours() < 48;
	}
}