package com.example.bookservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Abstract class that centralizes the path prefix "/book-service/v1"
 * for controller classes that extend RootController.
 */
@RequestMapping(path = "/book-service/v1")
public abstract class RootController {
}
