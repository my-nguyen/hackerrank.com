def chocolate_feast(data)
  # data[0] is dollar amount
  # data[1] is chocolate price
  # data[2] is the discount; the number of wrappers equivalent to one chocolate
  #
  # the number of wrappers based on the dollar amount
  wrappers = data[0] / data[1]
  # oririnally, chocolates is the same as wrappers
  chocolates = wrappers

  # start the exchange based on the number of wrappers and offer discount
  while wrappers >= data[2]
    # exchange wrappers for chocolates
    exchange = wrappers / data[2]
    chocolates += exchange
    # the number of wrappers includes the number of chocolates obtained from
    # the exchange, plus the number of wrappers left over from the exchange
    wrappers = exchange + (wrappers % data[2])
  end
  return chocolates
end

gets.to_i.times do
  puts(chocolate_feast(gets.split.map{|i| i.to_i}))
end
