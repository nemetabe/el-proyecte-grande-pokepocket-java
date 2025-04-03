import React from "react";

function TransactionCard({ transaction }) {
  const clr = "#ff5733"; // Hex szín

  return (
    <div
      className="h-15 border-2 rounded-[10px] flex items-center p-2"
      style={{ borderColor: clr }}
    >
      <div
        className="h-10 w-10 rounded-[0.5rem] mx-2"
        style={{ backgroundColor: clr }}
      ></div>
      <div className="flex flex-col basis-5/12 justify-normal">
        <div className="text-left">{transaction.name}</div>
        <div className="text-stone-500 text-[0.6rem] text-left">
          {transaction.date}
        </div>
      </div>
      <div className="flex justify-end basis-5/12">
        <div className="text-right">
          <div className="text-sm">{transaction.amount} HUF</div>
          <div className="text-stone-500 text-[0.8rem]">{transaction.category.description}</div>
        </div>
      </div>
    </div>
  );
}

export default TransactionCard;
