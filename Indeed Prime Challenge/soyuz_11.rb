def draw(size)
  puts("  /\\")
  size.times { puts("  ||") }
  puts(" /||\\")
  puts("/:||:\\")
  2.upto(size) { puts("|:||:|")}
  puts("|/||\\|")
  2.times { puts("  **") }
end

draw(gets.to_i)
